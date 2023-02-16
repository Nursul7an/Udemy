# Udemy
This is a task made in order to participate Hackathon. The task provided by the organization Makers Incubator and implemented for the following requirements.

- **Registration/Authorization**
- There will be 3 categories of access on the site:
- Super Administrator
- managing the application content through the Administrative Panel, adding/removing/changing categories on the site, removing mentors, checking and accepting courses
- Mentor
- can view/take/buy courses, also add/delete/change their courses
- User
- can view/take/buy courses

- **Mentor registration takes place in 2 stages**
- At the first stage, you need to fill in the following fields:
- Last name and First Name
- Email
- Password
- All fields are required to be filled in, otherwise display an error with a request to fill in the field
- And at the second stage, the Mentor needs to answer the following questions:
- What kind of teaching did you do before?
- personally, privately
- personally, professionally
- online
- other
- Do you have an audience with whom you want to share your course?
- not at the moment
- I have a small audience
- I have a sufficient audience

- **Mentor Authorization**
- The mentor can enter the site by filling in the following fields:
- via Gmail or
- Mail
- Password
- All fields are required to be filled in, otherwise display an error with a request to fill in the field

- **User Registration**
- When registering on the site, the User must fill in the following fields:
- Last name and First Name
- Email address
- Password
- All fields are required to be filled in, otherwise display an error with a request to fill in the field

- **User Authorization**
- The user can log in to the site by filling in the following fields:
- via Gmail or
- Mail
- Password
- All fields are required to be filled in, otherwise display an error with a request to fill in the field

- **Mentor and User Password Recovery**
- The User receives an email with a button to reset the old password.
- When you click on the “Change password“ button, it goes to the page where the User needs to:
- Create a new password
- Confirm new password
- 24 hours after sending the email, the password recovery link becomes inactive.

- Need to connect swagger


Markdown - Blockquotes
Markdown - Emphasis
Markdown - Heading
Markdown - Images
Markdown - Links
Markdown - Table
Markdown - Horizontal Rule
Markdown - Slack
Markdown - Superscript
Markdown - Twitch panels
Markdown - Jira
Markdown - List
Markdown - R studio
Markdown - Github checkbox
Markdown - Github checkbox
Markdown - PDF Conversion
Markdown - FAQ
Markdown - Folder Structure
Markdown - Github Image
Markdown - line break
Markdown - TOC
Markdown - CSS
Markdown - Letter List
Markdown - Text highlight
Markdown - Code Fenced
Markdown - Indent
ON THIS PAGE
How to add screenshot image to README.md on GitHub?
How to resize an image in markdown readme in GitHub?

Markdown - Github Image
This tutorial covers adding images or screenshots to the GitHub markdown README.md file and resizing images using syntax HTML image tag and examples..


Github has a README.md for every project that contains documentation about a repository.


Play

Unmute
Remaining Time -0:44

Auto(720pHD)
Share

Fullscreen
2 - How to add a file to git local repository staging area
README.md contains plain text with markdown syntax.

Sometimes, You want to add images to the README.md file. It includes a screenshot of images.

How to add screenshot image to README.md on GitHub?
README.md is a markdown file written with markdown syntax.


So adding an image to a markdown can be done in multiple ways.

use markdown image syntax.
The below syntax contains ![]() with alt text wrapped in square brackets[]and url and title are inside brackets()`.


![Alt text](url "Title")
Alt-text - is an image alt attribute text url- It contains a relative url or complete HTTP url


Relative URL example For example, if your image is in your repository, you can give url relative to your repository. If the image is located in repository->assets->employee.png url, Then the url is included as seen below

![Employee data](/repository/assets/employee.png?raw=true "Employee Data title")
raw=true to an image does not process during markdown to HTML conversion and is displayed as these.
It displays the image with title and alt content.

Generated HTML on a web page is

<img src="/repository/assets/employee.png" alt="Employee data" title="Employee Data title">
Hosted HTTP url:
if your image is hosted in hosted sites google and amazon cloud bucket or any image hosting providers, Please provide complete url

![Employee data](http://imageurl "Employee Data title")
use HTML image tag Another way is using the HTML img tag in the markdown readme file.
Since markdown supports including HTML tags and GitHub process as valid content.

<img src="https://tungsten-sphere-ea3.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fad7e2ab1-2944-4a12-a496-76fde0fcd673%2FUdemy_Authorizarion.png?id=ba50105c-c1f3-4ec3-97e3-5123ab10a887&table=block&spaceId=fd407aea-ce4c-4d14-9efe-c7ec0a978d11&width=620&userId=&cache=v2" width="50%" height="50%">




