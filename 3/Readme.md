# Selenium Test Cases:

 **1.  Test login**

**Source page:** https://practicetestautomation.com/practice-test-login/
**Web browser:** Chrome
**Programming language:** C#, NUnit

## Testing scenarios:

Use next credentials to execute Login:
Username: student
Password: Password123

 - Test case 1: Positive LogIn test
 
Open page.
Type username student into Username field.
Type password Password123 into Password field.
Puch Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in').
Verify button Log out is displayed on the new page.

 - Test case 2: Negative username test

Open page.
Type username incorrectUser into Username field.
Type password Password123 into Password field.
Puch Submit button.
Verify error message is displayed.
Verify error message text is Your username is invalid!

 - Test case 3: Negative password test
 
Open page.
Type username student into Username field.
Type password incorrectPassword into Password field.
Puch Submit button.
Verify error message is displayed.
Verify error message text is Your password is invalid!

 **2. Exceptions Page Tests**

Source page: https://practicetestautomation.com/practice-test-exceptions/
Web browser: Chrome
Programming language: C#

Testing scenarios:

 - Test case: TimeoutException

Open page.
Click Add button.
Wait for 3 seconds for the second input field to be displayed.
Verify second input field is displayed.
The second row shows up after about 5 seconds, so a 3-second timeout in the above test case.
