package org.logstashplugins;

import co.elastic.logstash.api.*;

import java.util.Collection;
import java.util.Collections;

@LogstashPlugin(name = "java_filter")
public class JavaFilter implements Filter {

    public static final PluginConfigSpec<String> SOURCE_CONFIG =
            PluginConfigSpec.stringSetting("source", "Hello Logstash");

    private final String id;
    private String sourceField;

    public JavaFilter(String id, Configuration configuration, Context context){
        this.id = id;
        this.sourceField = configuration.get(SOURCE_CONFIG);
    }

    @Override
    public Collection<Event> filter(Collection<Event> events, FilterMatchListener filterMatchListener) {
        for (Event e : events) {
            Object f = e.getField(sourceField);
            if (f instanceof String) {
                e.setField(sourceField, ((String) f).toUpperCase());
                filterMatchListener.filterMatched(e);
            }
            System.out.println(e.getData());
        }
        return events;
    }

    @Override
    public Collection<PluginConfigSpec<?>> configSchema() {
        return Collections.singletonList(SOURCE_CONFIG);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void close() {
        this.sourceField = null;
    }
}
