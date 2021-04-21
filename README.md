<h2>Execution</h2>
<p>The submission is a IntelliJ project that can be run directly from the IDE.</p>
<p>In CMD, 'javac JAVA-college-assignment\IntelliJ\src\Exercises\Main.java' and then 'java JAVA-college-assignment\IntelliJ\src\Exercises\Main'.</p>

<h2>Summary</h2>
<p>This exercise is a series of tests that can be done on a URL.</p>
<p>It is ment to be easy to add new commands and tests to the program.</p>


<h2>OOP design</h2>
<p>The design was made to be easy to add commands by using an interface and a super class.</p>
<p>In order to add a command, simply add a class that extends BaseCommand super class, add arguments to the constructer if needed and implement the action() method.</p>
<p>After that, make sure to add the command to the command factory.</p>
<p>In order to add another language to the language check command, simply add a "set" function with the correct frequency table and add the language to the method that sets the correct language.</p>



<h3>Check language explanation</h3>
<p>To check the web pages language, I created a frequency table for the web page and compared it to the english language frequenccy table.</p>
<p>The comparison was done by summing the squaered difference between each letters frequency.</p>
<p>If the variance is smaller than 0.04 it is considered the same language.</p>
<p>Small note: maybe a larger sample size is needed to determine the variance because I think I implemented it the right way but it returns true on french sites.</p>
