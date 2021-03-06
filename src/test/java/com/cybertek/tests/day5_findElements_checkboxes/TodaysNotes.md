MAY 19TH, WEDNESDAY

	- REVIEW ON XPATH AND CSS
	- How to move from parent to child and child to parent
	- findElement vs findElements
	- how to handle checkboxes and radio buttons


-------------------------------------------------------

	- cssSelector :
		- it is one of the 8 locators of Selenium
		- using cssSelector, we can create custom locators
		- we are not limited to only id, name and class attributes.
		- we can use ANY attribute and their values.

	syntax: tagName[attribute='value']

ex:

	<div id="tt55" name="oo00" for='something4'>
		<a href="https://google.com"> GOOGLE </a>
	</div>

- Locating div element using all of the attributes.

  --> div[id='tt55']
  --> div[name='oo00']
  --> div[for='something4']

  --> All of the above attributes are locating the SAME web element.


- HOW TO MOVE FROM PARENT TO CHILD USING CSSSELECTOR?
    - We use ">" sign to move from parent to child.

  syntax: tagName[attribute='value'] > childTagName

ex: Locating "Forgot password" header from http://practice.cybertekschool.com/forgot_password

	div[id='content'] > div > h2
	div[class='example'] > h2

- Why do we need to move from parent to child?
    - Sometimes the web element we are trying to locate does not have a unique attribute/value.
    - In this scenario, we can locate one of the parents that has a unique attribute value, and move down to child web element we are trying to locate.


- We CANNOT go from CHILD TO PARENT using cssSelector.

-------------------------------------------------------

	XPATH: 
		- 1 of 8 locators of Selenium.
		- Using xpath we can create custom locators.
		- We can use any attribute and value provided using xpath.
		- We can move from parent to child OR child to parent using xpath locator.

- How many types of xpath locators we have?
  - 2 types of xpath locators

  #1- ABSOLUTE XPATH:
  	- Absolute xpath starts with "/"
  	- We have to start from the root element, meaning "html" tag
  	- And we go down 1 by 1 to the desired web element
  	- It is not stable. If there is any minimal change happen in the html structure, our locator would break.
  	- It is not recommended to use.

ex: Locating "Forgot password" header from http://practice.cybertekschool.com/forgot_password

	Using absolute xpath.

	/html/body/div/div[2]/div/div/h2


	#2- RELATIVE XPATH:
		- Relative xpath starts with "//"
		- "//" means we can start anywhere in the html page.
		- We can use any attribute and value to be more specific on which web element we want to get.
		- Relative xpath is more reliable because we are being very specific with what we want.
		- We have multiple syntaxes for relative xpath

	syntax: 

#1- //tagName[@attribute='value']

	//toyota[@color='red']
	//toyota[@vin='asdfkl;jas;dfkjasdr98723498']
	//toyota[@plate='L44N23']

#2- //tag[.='text']
		--> this syntax locates using text

		ex: 	//label[.='E-mail']

#3- //tag[contains(@attribute, 'value')]
		--> this syntax locates using part of the given attribute value.
		--> it does not look for exact match	
		--> even partial match will work

	ex:
		//form[contains(@name, 'password')]


	-->	<input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">

	--> 	//input[contains(@pattern, 'a-z')]


--> How do we go from parent to child using XPATH?
- Using "/" we can go from parent to child.


		//tagName[@attribute='value'] / childTagName



ex: Locating "Forgot password" header from http://practice.cybertekschool.com/forgot_password
with xpath:

	//div[@id='content']/div/h2 --> will return "Forgot Password" header

	//div[@class='example']/h2

	driver.findElement(By.xpath("//div[@class='example']/h2"));


--> HOW TO GO FROM CHILD TO PARENT IN XPATH?
- Using "/.." we will go from child to parent

syntax:
//tagName[@attribute='value'] /..

IMPORTANT NOTE:
--> "//" in xpath means start from anywhere.
--> We can jump even after locating web element
--> see example below;

		//div[@id='content']//h2


xpath can do more than css, but it is little complex to write. - Css is slightly faster then xpath on IE, other browsers it is negligible.
- Css is easier to write and read,cleaner syntax

1.css cannot locate element using text
xpath://*[.="Don't Click"]
css: NA

2.css cannot find from matches based on index(different parents)
xpath:(xPathFormula)[indexNumber]
css: NA
3.css cannot locate child to parent
xpath: //button/../ --> move to parent
css: N






















