# encoding: utf-8
require "logstash/filters/base"
require "logstash/namespace"
require_jar('org.logstashplugins', 'logstash-filter-java_filter', '1.0.0')
require "#{File.dirname(__FILE__)}/../../lib/logstash-core.jar"
require "#{File.dirname(__FILE__)}/../../target/java-logstash-filter-plugin-0.0.1-SNAPSHOT.jar"

class LogStash::Filters::JavaFilter < LogStash::Filters::Base
  config_name "java_filter"

  def register
    # Java filter initialization
    @logger.info("Registering Java Filter")
  end

def self.javaClass() Java::org.logstashplugins.JavaFilter.java_class; end
end