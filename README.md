# Java

#Instalação do Java no Linux - Ubuntu |Java installation on Linux - Ubuntu


#Download do Repositório

sudo add-apt-repository ppa:webupd8team/java


#Atualizar as definições
sudo apt-get update


#Versão default Jre
sudo apt-get install default-jre


#Versão default Jdk
sudo apt-get install default-jdk

#Para instalar qualquer versão ou versão específica antes faça isto:

sudo apt-get install python-software-properties
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update

#Instalando o Java 8

sudo apt-get install oracle-java8-installer


#Gerenciando versões do Java

sudo update-alternatives --config java

#Testando versões
java -version

#Testando o compilador Java
javac -version
