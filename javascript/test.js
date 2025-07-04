const express = require("express");
const body_parser = require("body-parser");

const fs = require("fs");

const app = express();

app.use("/", express.static("."));

app.use(body_parser.urlencoded({ extended: false }));
app.use(body_parser.json());

app.get("/date", (req, res) => {
    res.send(JSON.stringify({now: new Date()}));
});
app.post("/picture", (req, res) => {
    //save the picture that we drew on canvas to our computer

    let jsonData = req.body;
    let points = jsonData.points;

    // fs.writeFileSync("picture.json", JSON.stringify(points));
    fs.writeFile("picture.json", JSON.stringify(points), () => {
        res.send(JSON.stringify({ success:true}));
    });
});
app.get("/getPicture", (req, res) => {
    fs.readFile("picture.json",(data) => {
        let points = JSON.parse(data);
        res.send({points:points});
    });
});

app.listen(3000);
console.log("Server is running on http://localhost:3000");
