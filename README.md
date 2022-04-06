# SE_exam


if maven not installed on archlinux: sudo pacman -S maven

to run server or client with intellij:  
sul terminale: mvn compile  
then run

if exception, to add dependences:  
on pom file: click R button -> generate -> dependences -> search for the required dependency

to see processes on ports (ex: 8080):  fuser 8080/tcp   
to remove processes on ports (ex: 8080):  fuser -k 8080/tcp  

to create jar: add dependency on pom and on terminal mvn package  
check if a folder named target is created with a .jar file inside

----------------------------------------------------------------------------------------
GRPC  
https://github.com/lrazovic/grpc-comparison  


----------------------------------------------------------------------------------------

to activate activemq on labs or exams if needed (in JMS examples):  
sudo docker pull rmohr/activemq  
sudo docker run -p 61616:61616 -p 8161:8161 rmohr/activemq  
http://localhost:8161 (check connection)  

to install docker:  
https://www.simplilearn.com/tutorials/docker-tutorial/how-to-install-docker-on-ubuntu  

to solve docker-compose problem:  
sudo curl -L "https://github.com/docker/compose/releases/download/1.26.0/docker-compose-$(uname -s)-$(uname -m)"  -o /usr/local/bin/docker-compose  
sudo mv /usr/local/bin/docker-compose /usr/bin/docker-compose  
sudo chmod +x /usr/bin/docker-compose  

docker commands:  
docker ps    (list of all active containers)  
docker stop "container_name"   (stops that container)

----------------------------------------------------------------------------------------

to see versions of java installed:  
sudo archlinux-java status  

to install java16:  
sudo pacman -Syu jdk-openjdk

to solve glibc problem:  
pacman -Sw glibc lib32-glibc  
pacman -S glibc lib32-glibc

to set the wanted version of java:  
sudo archlinux-java set "nome versione stampata in precedenza"

(alternative way to install java16 on archlinux):  
to check if it is installed: java -version  
install jre in arch linux: sudo pacman -sS java | grep jre  
install latest version of jre: sudo pacman -S jre-openjdk  
to install jdk in archlinux: sudo pacman -sS java | grep jdk  
install latest version of jdk: sudo pacman -S jdk-openjdk  

--------------------------------------------------------------------------- 
CREARE PROGETTO MAVEN IN NETBEANS  
new project -> maven -> java application -> i pacchetti chiamali tipo it.uniroma1  
 
--------------------------------------------------------------------------- 
DATABASE  
da terminale: sqlite3 "nomeDB".db  
.databases  
metto path dentro ai paramentri della configurazione del DB con secondo parametro "create"  
es: "path" create  
poi per verificare il contenuto del db: path "stringa scelta"    (dentro a configurazione)  
  
oppure:  
da terminale: sqlite3 path/"nomeDB".db

NB: quando devo inserire il path, se metto le virgolette " " al path mi prende anche gli spazi nei nomi delle cartelle   

---------------------------------------------------------------------------

 CREATE .jar FILE  
 mvn package (nel ternimale) e crea un .jar file nella cartella target
 
 --------------------------------------------------------------------------
 SOAP  
 dentro a WSInterface.java bisogna aggiungere @WebService e l'import  
 dentro a WSImplService-java bisogna aggiungere @WebService(endpointInterface ecc..)  
 
 per vedere gli elementi del db con soap andare su: "http://0.0.0.0:7070/WSInterface?wsdl"  
 
 ------------------------------------------------------------------------------  
 REST  
 per vedere gli elementi del db con rest andare su: "http://localhost:8080/"  

