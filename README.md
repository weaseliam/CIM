# CIM project

## How to build and run project
Required tools
* Git
* JDK8
* Maven (v3+)

Clone project.  
Build it with `mvn clean install` in project root.  
Run it with `java -jar [web-application].war` in _web/target_ folder.  
Check it out at `http://localhost:8080`  

## How to setup DEV environment
Required tools
* Git
* JDK8
* Maven (v3+)
* NodeJs (v6+)
* SpringTools Suite (eclipse)
* Visual Studio Code (client UI)

Set the following environment variables:  
Create a new env variable `JAVA_HOME` which points to JDK installation root path (eg `C:\Program Files\Java\jdk1.8.0_51`)  
Add the `JAVA HOME` var to `PATH`: `%JAVA_HOME%/bin`  
Create a new variable `MAVEN_HOME` which points to maven installation root path (eg `C:\Program Files (x86)\apache-maven-3.5.0`)  
Add `MAVEN_HOME` to `PATH`: `%MAVEN_HOME%/bin`  
Open a new command prompt (Winkey + R then type `cmd`) and run `mvn -v` to verify the installation.  
Do te same for java: `java -version`  

#### Clone project using git bash:
```sh
git clone https://github.com/weaseliam/CIM.git
git checkout <other branch name>
cd CIM
```
Build it with `mvn clean install [-DskipTests]` in project root (CIM folder).

#### Spring Tools Suite (STS) configuration
1. Link JDK 1.8 to the project: 
   Window -> Preferences -> Java -> Installed JREs -> Add -> Select JDK 1.8 -> make as default

2. Change default encoding of the workspace: 
   Window -> Preferences -> General -> Workspace -> Text fine encoding -> Other -> UTF-8

3. Organize imports:
   Window -> Preferences -> Java -> Editor -> Save Actions -> Check "Perform the selected actions.. -> Check "Organiuze imports"

4. Import new code formatter:
   Window -> Preferences -> Java -> Code Style -> Formatter -> Import xml formatter file

5. Modify Diffs view
   Window -> Preferences -> General -> Editors -> Text Editors -> Quick Diff -> Enable Quick Diff -> Enable "Show Differences .." -> change the refference resource to "A Git Revision"

6. Disable Validation:
   Window -> Preferences -> General -> Validation -> Disable All validators

7. Link Maven to STS:
   Window -> Preferences -> Maven -> Installations -> Add -> Set the instalation home directory to the home dir -> Select the new Maven dir and click ok.

8. Import Maven Project to STS
   File -> Import -> Maven -> Existing Maven projects - Browse -> Select the root directory (CIM) (deselect ui project)

#### Run project in STS (server):
Select `cim-web` project -> Run/Debug as Spring Boot App.

#### Run project in Visual Studio Code (client)
File -> Open Folder -> select the UI project root folder.  
Open a terminal (Ctrl + `) and type:  
```sh
npm install
npm run start
```

For more npm run options, please check package.json scripts.  
In Browser -> go to `http://localhost:3000` for verification.  
