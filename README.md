# IntervueAssignment
Selenium automation assesment 

**Requiements:**
1.Ecplise IDE
2.Selenium WebDriver Jar files
3.Selenium ChromeDriver

**Youtube Video links to setup:**

Installing Ecplise IDE and Configuring Selenium Jar files
(https://www.youtube.com/watch?v=IkK7bS6hLms)

Setting up chromedriver  - basically only the path to the chromedriver should be replaced video is for your reference
(https://www.youtube.com/watch?v=DFuBWi8r61s)

**Download links**

	Ecplise IDE link - (https://www.eclipse.org/downloads/)

	Selenium Jar files link - (https://www.selenium.dev/downloads/)

	Selenium ChromeDriver link - (https://googlechromelabs.github.io/chrome-for-testing/#stable)


**Important:**

If you do not wish to import and want only the scripts they are available in Myproject001->src -> Two jave files, one is used to store credential as it is not hardcoded another intervue.java the main file




  Steps : 
  1.Download EcpliseIDE,Selenium ChromeDriver and Selenium WebDriver java and extract if necessary
  
  2.Download Myproject001.rar from github and extract it  
        you can follow my uploaded video in github video names
              ->Creating_And_importing_the_Project.mp4
              ->AddingSeleniumJarfiles_And_AddingSeleniumChromeDriver_Path.mp4
  
        3.In ecplise create a new project with the name Myproject001 ,rightclick on project name and import the Myproject001 file downloaded from github
	
        4.Once import is done again right click on project name ,go to properties,selet java build path, then select libraries
        
	5.In libraries click on classpath and select Add external jars and select all the extracted WebDriver files , Apply and close
        
	6.In the script intervue.java(located in Myproject001->src).In System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe"); replace the chromedriver path with the path where you                 extracted the chromedriver in the end add the file name (chromedriver.exe)     
  
  


NOTE:

	- Replacing the ChromeDriver path and path where screenshots need to be saved ,in 'intervue.java'class file is the only change needed to be done in the program.
      - For some reason the search option after loging in companies section is glitching/bug meaning sometimes it is not responsive even on manual clicks the program does take a screenshot ,but if this issue occurs please rerun the program couple of times it will work fine i have added the output video as well.

