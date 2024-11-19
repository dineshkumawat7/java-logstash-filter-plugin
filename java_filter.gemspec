
Gem::Specification.new do |spec|
  spec.name          = "logstash-filter-java_filter"
  spec.version       = "1.0.0"
  spec.authors       = ["Dinesh Kumawat"]
  spec.email         = ["dkumawat7627@gmail.com"]
  spec.summary       = "A custom Logstash filter plugin written in Java."
  spec.description   = "This plugin demonstrates how to build a custom filter plugin using Java."
  spec.homepage      = "http://www.elastic.co/guide/en/logstash/current/index.html"
  spec.license       = "Apache-2.0"
  spec.require_paths   = ['lib', 'target', 'libs']

  # Include all necessary files
  spec.files         = Dir["lib/**/*.rb", "target/**/*.jar", "libs/logstash-core.jar", "README.md"]

  # Runtime dependencies
  spec.add_runtime_dependency "logstash-core", "~> 8.15.1"


#   spec.executables   = ["logstash-filter-java_filter"]
#   spec.require_paths = ["lib"]
end