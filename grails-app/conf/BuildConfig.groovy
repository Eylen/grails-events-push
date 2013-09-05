grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.dependency.resolver = "maven"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.tomcat.nio = true
//grails.plugin.location.'platformCore' = '../../platform-core'


grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
	    excludes("xml-apis", "commons-digester")
    }

	log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	repositories {
        mavenLocal()
        grailsCentral()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "https://oss.sonatype.org/content/repositories/snapshots"
    }
    dependencies {
	      compile 'org.grails.plugins:events:1.0.0.BUILD-SNAPSHOT'
        compile('org.atmosphere:atmosphere-runtime:2.0.0.RC3') {
            excludes 'slf4j-api', 'atmosphere-ping'
        }
    }

    plugins {
	    runtime (":jquery:1.10.2", ":hibernate:3.6.10.M6") {
            export = false
        }

        runtime(":resources:1.2")
        build(":tomcat:7.0.42",
                ":release:3.0.0", ":rest-client-builder:1.0.3"
        ) {
            export = false
        }
    }
}
