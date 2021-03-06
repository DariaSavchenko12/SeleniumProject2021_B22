MAY 16TH, SUNDAY FUNDAY

TODAY'S SCHEDULE:

	#1- Review
	#2- Tasks
	#3- Utility method
	#4- cssSelector
	#5- xpath

----------------------------------------------------------------------

What is Maven?

	- Build automation tool for creating java projects.


What is "build"?

	- Repeated steps when we are creating a project.

Is Maven the only tool for build automation?

	- No.
	- ant, Gradle

What does findElement(By.LOCATOR("STRING")) method do?

	- Finds and returns a SINGLE web element.

What is the return type of findElement()?

	- returns WebElement type coming from Selenium library.

What kind of exception does it throw?

	- NoSuchElementException


What are common reasons you would get NoSuchElementException?

	#1- Most likely locator might not be correct.
	#2- Page (or WebElement we are trying to locate) is not loaded
		- BrowserDriver is not on the same page with the browser.


What are locators?
- Methods coming from Selenium library that helps us find WebElements.

How many locators do we have?
- There are 8 locators.

	#1- id
	#2- className
	#3- tagName
	#4- name
	#5- linkText
	#6- partialLinkText

-----------------------------------------------------------------

--> getText() method questions:

- What does getText() method do?
    - Returns the text of the given WebElement


- What is the return type? What does it return it as?

    - String

- Does it accept any argument?

    - No.

syntax: We must locate a webElement to be able to use .getText() method.

	driver.findElement(BY.LOCATOR).getText();



--> getAttribute() method questions:

- What does getAttribute() method do?
    - it accepts attribute name and returns its value
    - return the value of the given attribute in a tag

- What is the return type?
    - String

- Does it accept any argument?
    - Yes.
    - It accepts a String argument.

syntax:

	- driver.findElement(By.Locator).getAttribute("href");
	- this will return the value of "href" attribute


EX: <a href="https://www.tesla.com" id="uh7" name="bb95"> TESLA </a>

--> Which texts I can get with only getText();
- "TESLA"
- I can only get the text from in between the openingTag and closing tag using .getText() method

--> Which texts I can get with only getAttribute("attributeName");

getAttribute("attributeName");

	- We can get the value of:
		- href --> https://www.tesla.com 
		- id --> uh7
		- name --> bb95

-----------------------------------------------------------------
Shoe Factory --> Creating shoes
Baloon Factory --> Creating baloons
WebDriverFactory --> Creating WebDriver

-> Advantages of creating utility methods:
- Good for repeating actions: create once, use repeatedly as needed.
- Easy to maintain your code with utility methods

	ex: Lets say you need to change browser driver from 

	 WebDriverManager.chromedriver().setup();

	 to 

	  WebDriverManager.chromedriverA().setup();

- if you created a utility method, instead of going in different classes (everywhere you called that line), you just fix it from 1 location (utility method)
- Fixing one line will update the rest of the project.
- This way our code will be easy to maintain.

-> If our method is "static" we don't have to create an object of that class to be able to reach the specific method.


-----------------------------------------------------------------

#7 - cssSelector (LOCATOR):
	- cssSelector is one of 8 locators of Selenium.
	- with cssSelector we are able to create CUSTOM locators.
	- using cssSelector you will be able to locate web elements with ANY OF THE ATTRIBUTES PROVIDED inside of the tag
	- we are not just limited to name, class, or id attributes anymore
	- we can use ANY attribute inside of the tag.

There are 2 different syntaxes in cssSelector:

SYNTAX #1:

	tagName[attribute='value']


ex: <a href="https://www.tesla.com" id="uh7" name="bb95"> TESLA </a>

	#1- locate above link with cssSelector using id:
		 
		a[id='uh7']

	#2- locate above link with cssSelector using name:

		a[name='bb95']

	#3- locate above link with cssSelector using href:	

		a[href='https://www.tesla.com']

NOTE: If you want to be less specific, you don't have to pass tagName with this locator.

	[attribute='value']

	[id='uh7']

	[name='bb95']



SYNTAX #2 -
- Second syntax is limited to use with "id" and "class" only.

	tagName#idValue
	tagName.classValue

	# ---> stands for id attribute
	. ---> stands for class attribute

ex: <a href="https://www.tesla.com" id="uh7" name="bb95" class="kk99"> TESLA </a>

#1- locate above link with cssSelector syntax #2 using id:

	a#uh7 --> this will return me the above web element


#2- locate above link with cssSelector syntax #2 using class attribute value:

	a.kk99


NOTE: If you want to be less specific, you dont even have to type the tagName.

	#idValue
	.classValue


HOW TO OPEN SEARCH BAR IN CHROME DEVELOPER TOOL (CHROME INSPECT PAGE)

	- MAC		: COMMAND + F
	- WINDOWS 	: CONTROL + F

EX:

<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">

SYNTAX #1:

	tagName[attribute='value']

	input[type='text']
	input[id='twotabsearchtextbox']

--------------------------------------------------------------------------------

.isDisplayed();

- What this method does?
    - It will verify if the method on the page is displayed or not.

- What is the return type?
    - boolean: true/false

    - If the web element is displayed on the page it will return : true
    - If the web element is NOT displayed on the page it will return : false

- It does not accept any arguments.
- You need to use this method on an already located web element.



tagName[attribute='value']

<label for="email">E-mail</label>

label[for='email']


--------------------------------------------------------------------------------

#8 - XPATH:
	- xpath is one of 8 locators in Selenium.
	- xpath allows us to create custom locators using any given attribute and value.
	- We can also use the text of the web element create locator using XPATH.

	- xpath syntax is different than cssSelector.

There are 2 types of XPATH:

#1- ABSOLUTE XPATH:
	- Starts with single slash "/"
	- Starts looking from the root/parent/ascendent element in the HTML page
	- It starts from the html tag and it goes 1 by 1 until we reach the desired web element
	- Usually it is very very long, and it is NOT dependable.
	- Because it is long, it is not stable, therefore it is NOT used much.
	- It is not recommended to use it as locator in our code.

	<html>
		<head>
			<title> Title of the page </title>
		</head>
		<body>
			<div>
				<div> 
					<a href=""> TEXT </a>
				</div>
			</div>

		</body>

	</html>

ex: locating link <a> tag above using absolute xpath

	/html/body/div/div/a

- With any minimal change in the HTML code, this locator will be breaking. Therefore, not good practice to use ABSOLUTE XPATH.


#2- RELATIVE XPATH:
	- Starts with double slash "//"
	- "//" means that you can start anywhere in the HTML page
	- Since we are allowed to start anywhere in the HTML page, relative xpath is very dependable and useful
	- The only time your relative xpath is supposed to be breaking is if ONLY the attribute value you use is changed.

--> MAIN SYNTAX

	//tagName[@attribute='value']



ex: <a href="https://www.tesla.com" id="uh7" name="bb95"> TESLA </a>

#1- locating with href	: //a[@href='https://www.tesla.com']
#2- locating with id 	: //a[@id='uh7']
#3- locating with name 	: //a[@name='bb95']


	- We are NOT limited with id, name, class, or href attributes.
	- We can use any custom attribute and their value with XPATH locator.


COMMONLY USED XPATH SYNTAXES:

	#1 - //tagName[@attribute='value']
	#2 - //tagName[contains(@attribute, 'value')]
	#3 - //tagName[.='text']
	#4 - //*[@attribute='value']

EXPLANATIONS:
#1- //tagName[@attribute='value']

	- We are saying, get me the web element with given tagName, where attribute value is as provided.

	#2- //tagName[contains(@attribute, 'value')]
	
	- Looks for the tagName that has matching or containing attribute value

	#3- //tagName[.='text']
	
	- This locator will return the web element with given text.
	- Works in similar way to linkText locator. But linkText only works with links.
	- Xpath will work with any web element.
	- . --> stands for text in xpath

	#4- //*[@attribute='value']

	- * --> is used when we do not want to search by a tagName.
	- If we want to be less specific, we pass *, and it will only match and return whatever attribute and value is provided.

- I DO NOT SUGGEST USING ANY TOOL THAT WILL AUTO GENERATE XPATH FOR YOU UNTIL YOU GET A JOB.

right click > copy > copy xpath --> auto generated xpath

CHROPATH













