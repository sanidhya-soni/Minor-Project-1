const express = require("express");
const bodyParser = require("body-parser");
const ejs = require("ejs");


const app = express();
app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));



app.get("/", function (req, res) {
    res.render("home");
});

app.get("/about", function (req, res) {
    res.render("about");
});

app.get("/inventory", function (req, res) {
    res.render("inventory");
});

app.get("/stock", function (req, res) {
    res.render("stock");
});

app.get("/dispatch", function (req, res) {
    res.render("dispatch");
});



// app.get("/compose", function (req, res) {
//     res.render("compose");
// });

// app.post("/compose", function (req, res) {
//     var post = {
//         title: req.body.postTitle,
//         content: req.body.postBody
//     }
//     posts.push(post);
//     // console.log(posts);
//     res.redirect("/");

// });

app.listen(3000, function () {
    console.log("Server started on port 3000");
});
