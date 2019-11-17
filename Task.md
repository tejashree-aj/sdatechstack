# My SDA Forum

Your task for this part of the module will be to take the Spring + React template 
application you have received and turn it into an online discussion forum. As you 
see, some parts have been done for you. For example, you will not need to worry about how
to handle the authentication (registration and login) as that has already been fixed.

As we're keeping it relatively simple, we will only be adding minimal functionality.
Simplified, the functionalities to add are:
- Make a post 
- Delete a post
- View all posts
- Write a comment on a post
- Delete a comment on a post
- View all comments on a post

The web application is made up of three parts: database, backend and frontend. You will
be doing work on the backend (Spring) and frontend (React). Both Spring and React are
quite big and complex tools. Knowing how to use them takes some time but when you do,
they are very useful and offer a great amount of help. The usual problem when you're
faced with big frameworks you haven't used before is knowing where to start. Therefore,
we are going to make it easier for you by giving you recommended courses of action.

### Page Branding
One thing you'll notice when you click around your web application is that it looks generic. It says SDA 6 starter
template in some places and it doesn't really give you an idea of what the website is about.

Your first task is
to brand your page by switching out all the SDA 6 starter template placeholders and replacing them with your own
brand name and logo. You should also give a quick introduction text on the landing page (and home page) that says what your forum is about.
You are free to choose the theme of your forum (could be environment, food/drinks, agriculture or even a forum entirely dedicated
to [this guy](https://upload.wikimedia.org/wikipedia/commons/7/7b/Richard_Stallman_-_F%C3%AAte_de_l%27Humanit%C3%A9_2014_-_010.jpg)).
Tip: for the name and logo these websites might come in handy:
- https://namelix.com/
- https://hatchful.shopify.com/

Be creative! You can also choose to change the background image, the font styles, etc.

### Post
One of the first things you'll probably notice is that when you try to make a post, nothing really happens. If you
open up the developer tools and go to Network and try to make a post. You will see that each time you click, a request
is actually being sent (to which address?) but it receives a 404 status code which means that the server could not
find what was requested. So the client-side (or frontend) is actually done here, it is doing what it's supposed to.
It is the server-side (backend) that needs to be fixed.

Your task is to implement the code for the Post resource on the server. This means that in your backend, you need to
- Make the `Post` class persistent using hibernate annotations on it.
- Implement the `PostRepository` interface so that you can do CRUD (Create, Read, Update, Delete) operations on Post class instances.
- Complete the `PostService` class which will use an instance of the `PostRepository` class to retrieve, edit, create and
delete posts on more abstract level.
- Finish the `PostController` which will handle requests coming from the client side and use the `PostService` to serve
the requests.

### Comment

 
