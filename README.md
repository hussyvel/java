# Java

#Instalação do Java no Linux - Ubuntu |Java installation on Linux - Ubuntu


#Download do Repositório:

sudo add-apt-repository ppa:webupd8team/java


#Atualizar as definições:
sudo apt-get update


#Versão default Jre:
sudo apt-get install default-jre


#Versão default Jdk:
sudo apt-get install default-jdk


sudo apt-get update

#Instalando o Java 8:

sudo apt install openjdk-8-jdk



#Gerenciando versões do Java:

sudo update-alternatives --config java

#Testando versões:
java -version

#Testando o compilador Java:
javac -version


#Instalando o eclipse

baixar no site 
https://www.eclipse.org/downloads/

Copie de downloads para onde deseja; No meu caso foi:

chmod +x '/home/hussyvel/Documents/eclipse-inst-linux64.tar.gz' 

tar -vzxf '/home/hussyvel/Documents/eclipse-inst-linux64.tar.gz' 

Após isto é só clicar no executável dentro da pasta Documents

