package org.logstashplugins;

import co.elastic.logstash.api.Configuration;
import co.elastic.logstash.api.Context;
import co.elastic.logstash.api.Event;
import co.elastic.logstash.api.FilterMatchListener;
import org.junit.Assert;
import org.junit.Test;
import org.logstash.plugins.ConfigurationImpl;
import org.logstash.plugins.ContextImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaLogstashFilterPluginApplicationTests {

	@Test
	public void testJavaExampleFilter() {
		String sourceField = "name";
		Configuration config = new ConfigurationImpl(Collections.singletonMap("source", sourceField));
		Context context = new ContextImpl(null, null);
		JavaFilter filter = new JavaFilter("test-id", config, context);

		Event e = new org.logstash.Event();
		TestMatchListener matchListener = new TestMatchListener();
		e.setField(sourceField, "dinesh kumawat");
		Collection<Event> results = filter.filter(Collections.singletonList(e), matchListener);

		Assert.assertEquals(1, results.size());
		Assert.assertEquals("DINESH KUMAWAT", e.getField(sourceField));
		Assert.assertEquals(1, matchListener.getMatchCount());
	}

}

class TestMatchListener implements FilterMatchListener {

	private AtomicInteger matchCount = new AtomicInteger(0);

	@Override
	public void filterMatched(Event event) {
		matchCount.incrementAndGet();
	}

	public int getMatchCount() {
		return matchCount.get();
	}
}