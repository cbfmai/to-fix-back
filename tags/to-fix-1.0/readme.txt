For documnetation and source code see the homeapage: http://www.tomac.org/fix or http://code.google.com/p/to-fix/

-- QUICK START --

To Create Your Own FIX implemntation:
1. Create your maven project; example my-fix
in the to-fix dir, run
mvn archetype:generate -DgroupId=com.mydomain -DartifactId=myfix -DarchetypeArtifactId=maven-archetype-archetype

2. Create your xml file. See the existing fix inplemtations xml files to use as template. place it under 

3. Modify the pom.xml to include the requied dependecies

4. Build it
mvn install



-- DEPLOYING AND STAGING ARTIFACTS --

To build:
mvn clean install

To deploy a snapshot:
(por prerequisites see https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide)
mvn clean deploy


To deploy a SNAPSHOT, make sure the 'version' element in your pom.xml the 'version' property in your build.xml has a SNAPSHOT version value (like 1.0-SNAPSHOT).
In order to deploy a snapshot add the following to your m2 settings.xml file
  <servers>
    <server>
      <id>sonatype-nexus-snapshots</id>
      <username>uuuuuu</username>
      <password>xxxxxxx</password>
    </server>
  </servers>

To prepare a release:

mvn release:clean
mvn release:prepare

Thenstage therelase:

mvn release:perform

To stage a release, make sure the 'version' element in your pom.xml the 'version' property in your build.xml has a RELEASE version value (like 1.0), then run ant stage.
In order to stage a relsease add the following to your m2 settings.xml file
The pgp executable must be in the PATH.
  <servers>
    <server>
      <id>sonatype-nexus-staging</id>
      <username>uuuuuuu</username>
      <password>xxxxxxx</password>
    </server>
  </servers>
  <profiles>
    <profile>
      <id>gpg</id>
      <properties>
        <gpg.passphrase>yyyyyy</gpg.passphrase>
      </properties>
    </profile>
  </profiles>

  Donwlode the staged jars from https://oss.sonatype.org/content/repositories/statging/org/tomac and upload them to "downloads" on http://code.google.com/p/to-fix/
  
  
