function SaveToJson() {
    this.buttonJson = document.getElementById("json");
    this.returnButton = document.getElementById("return");
}

SaveToJson.prototype.initSettings = function() {
    
    this.buttonJson.addEventListener('click', () => {
        let xhr = new XMLHttpRequest();
        xhr.onloadend = function(e) {
            document.getElementById("noteSavings").innerHTML = "Данные сохранены";
            setTimeout(() => {
                document.getElementById("noteSavings").innerHTML = "";
            }, 1200);
            console.log(this.responseText);
        }
        let uri = "http://localhost:8080/ajaxpost";
        let data = "jsonData=" + this.createJson();
        data += "&" + "id=" + document.getElementById("idMysql").value;
        xhr.open("POST", uri, true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send(data);
//        xhr.send("fname=Henry&lname=Ford");
        console.log("hello from ajax");
//        console.log(this.createJson());
    });
    
}

SaveToJson.prototype.createJson = function() {
    let data = {
        id: document.getElementById("idMysql").value,
        title: document.getElementById("title").value,
        body: document.getElementById("bodyNote").value,
        data: document.getElementById("dateMysql").value
    };
    
    return JSON.stringify(data);
}

SaveToJson.prototype.returnToMain = function() {
    this.returnButton.addEventListener('click', () => {
        location.href = "http://localhost:8080/main";
    });
}

const saveAction = new SaveToJson();

export {saveAction};