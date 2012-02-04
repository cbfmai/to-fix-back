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
mvn release:prepare -Dusername=sebastian.tomac@gmail.com -Dpassword=xxxxxxx

Then stage the relase:

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

Release the stage: 

Login to the Nexus UI. https://oss.sonatype.org/index.html#stagingRepositories
Go to Staging Repositories page.
Select a staging repository.
Click the Close button.

Download the staged jars from https://oss.sonatype.org/content/repositories/statging/org/tomac and upload them to "downloads" on http://code.google.com/p/to-fix/


-- EXAMPLE FIX SPECIFICATIONS --

LSE Group
FIX50LSE-order.xml http://www.londonstockexchange.com/products-and-services/millennium-exchange/millennium-exchange-migration/mit202v9.pdf
FIX50LSE-order.xml http://www.londonstockexchange.com/products-and-services/millennium-exchange/millennium-exchange-migration/mit202v9.pdf

Chi-X
FIX42ChiXEurope.xml http://www.chi-xeurope.com/document-library/chi-x-fix-4.2-notes-v1.27.pdf 
FIX42ChixEast.xml http://chi-east.com/resources/file/Chi-East_FIX_Trading_Interface_Specification_v1_6-8.pdf 
FIX42ChiXJapan.xml http://www.chi-x.com/resources/jp/file/Docs/Chi-X%20Japan%20Trading%20Interface%20Specification-v1_6_16.pdf

NYSE Euronext
FIX42NyseEuronext.xml http://europeanequities.nyx.com/sites/europeanequities.nyx.com/files/IT_Dev_FIXX_Protocol_PROD_Universal_Trading_Platform_for_Cash_Markets_CCG_FIX_4_2_message_specifications_v2_8_EN.pdf

Deutsche Bšrse
N/A

Nasdaq OMX 


SIX Swiss Exchange
N/A

Bolsa de Madrid
N/A

Turquoise


BATS 
FIX42BatsEurope.xml http://www.batstrading.co.uk/resources/participant_resources/BATS_Europe_FIX_Specification.pdf

DARK Books

Chi-X
See above

Turquoise
See above

UBS MTF 
N/A

ITG Posit
N/A

BATS
See above

SIGMA X MTF
FIX42SigmaXMTF.xml http://gset.gs.com/sigmaxmtf/infoParticipants.asp



  
  
