let numberAuthors=0;
let numberPerformers=0;
function addAuthor(){

    numberAuthors++;

    var authorsEl= document.getElementById('authors-group');
    var authorName = $.trim($('#authorAdd').val());

    for (let i=1; i< numberAuthors; i++){
        var temp= $.trim($('#author'+i).val());
        if(temp === authorName){
            return;
        }
    }

    if (!(authorName === "")) {
        let div = document.createElement('div');
        div.className = "input-group mb-2 col";
        div.id = 'author-group' + numberAuthors;

        let inputBlock =
            '<input type="text" readonly class="form-control" ' +
            'value="' + authorName +
            '" id="author' + numberAuthors +
            '" name="authors' +
            '" aria-describedby="delete-author-btn' + numberAuthors +
            '"/>';
        let buttonBlock =
            '<button class="btn btn-secondary" ' +
            'id="delete-author-btn' + numberAuthors +
            '" onclick="deleteElById(\'authors-group\', \'author-group' + numberAuthors + '\')' +
            '" type="button">' +
            'Удалить' +
            '</button>';

        div.innerHTML = inputBlock + buttonBlock;
        authorsEl.append(div);
    }

};

function deleteElById(nodeElId, elId){

    var authorsEl= document.getElementById(nodeElId);
    var deletedEl= document.getElementById(elId);

    authorsEl.removeChild(deletedEl);
    numberAuthors--;
};

function addPerformer(){

    numberPerformers++;

    var performersEl= document.getElementById('performers-group');
    var performerName = $.trim($('#performerAdd').val());

    for (let i=1; i< numberPerformers; i++){
        var temp= $.trim($('#performer'+i).val());
        if(temp === performerName){
            return;
        }
    }

    if (!(performerName === "")) {
        let div = document.createElement('div');
        div.className = "input-group mb-2 col";
        div.id = 'performer-group' + numberPerformers;

        let inputBlock =
            '<input type="text" readonly class="form-control" ' +
            'value="' + performerName +
            '" id="performer' + numberPerformers +
            '" name="performers' +
            '" aria-describedby="delete-performer-btn' + numberPerformers +
            '"/>';
        let buttonBlock =
            '<button class="btn btn-secondary" ' +
            'id="delete-performer-btn' + numberPerformers +
            '" onclick="deleteElById(\'performers-group\', \'performer-group' + numberPerformers + '\')' +
            '" type="button">' +
            'Удалить' +
            '</button>';

        div.innerHTML = inputBlock + buttonBlock;
        performersEl.append(div);
    }

};

function addOldAuthor(name){

    numberAuthors++;

    var authorsEl= document.getElementById('authors-group');
    var authorName = name;

    if (!(authorName === "")) {
        let div = document.createElement('div');
        div.className = "input-group mb-2 col";
        div.id = 'author-group' + numberAuthors;

        let inputBlock =
            '<input type="text" readonly class="form-control" ' +
            'value="' + authorName +
            '" id="author' + numberAuthors +
            '" name="authors' +
            '" aria-describedby="delete-author-btn' + numberAuthors +
            '"/>';
        let buttonBlock =
            '<button class="btn btn-secondary" ' +
            'id="delete-author-btn' + numberAuthors +
            '" onclick="deleteElById(\'authors-group\', \'author-group' + numberAuthors + '\')' +
            '" type="button">' +
            'Удалить' +
            '</button>';

        div.innerHTML = inputBlock + buttonBlock;
        authorsEl.append(div);
    }

};

function addOldPerformer(name){

    numberPerformers++;

    var performersEl= document.getElementById('performers-group');
    var performerName = name;

    for (let i=1; i< numberPerformers; i++){
        var temp= $.trim($('#performer'+i).val());
        if(temp === performerName){
            return;
        }
    }

    if (!(performerName === "")) {
        let div = document.createElement('div');
        div.className = "input-group mb-2 col";
        div.id = 'performer-group' + numberPerformers;

        let inputBlock =
            '<input type="text" readonly class="form-control" ' +
            'value="' + performerName +
            '" id="performer' + numberPerformers +
            '" name="performers' +
            '" aria-describedby="delete-performer-btn' + numberPerformers +
            '"/>';
        let buttonBlock =
            '<button class="btn btn-secondary" ' +
            'id="delete-performer-btn' + numberPerformers +
            '" onclick="deleteElById(\'performers-group\', \'performer-group' + numberPerformers + '\')' +
            '" type="button">' +
            'Удалить' +
            '</button>';

        div.innerHTML = inputBlock + buttonBlock;
        performersEl.append(div);
    }

};


    function sendUserInfo(){

        var userId= $.trim($('#id').val());
        var userNickname = $.trim($('#nickname').val());
        var userEmail = $.trim($('#email').val());
        var userPassword = $.trim($('#password').val());
        var userConfirmPassword = $.trim($('#confirm-password').val());

        if (!(userPassword === userConfirmPassword))
        {
            alert('пароли не совпадают');
            return false
        }
        /*
                let selectUserMainTrackListElement = document.getElementById(selectUserMainTrackIdName);

                let trackId;
                console.log(selectUserMainTrackListElement.selectedIndex);
                if (selectUserMainTrackListElement.selectedIndex === undefined || selectUserMainTrackListElement.selectedIndex == null || selectUserMainTrackListElement.selectedIndex == -1) {
                    trackId = null;
                }
                else {
                    trackId = selectUserMainTrackListElement.options[selectUserMainTrackListElement.selectedIndex].value;
                }*/

        var raw = `{\"id\": \"${userId}\", \"nickname\": \"${userNickname}\", \"password\": \"${userPassword}\", \"passwordConfirm\": \"${userConfirmPassword}\"`;

        if (userEmail !== undefined && userEmail != "") {
            raw += `, \"email\": \"${userEmail}\"`;
        }

        /*
                if (trackId !== undefined && trackId != null) {
                    raw += `,\"music_avatar_id\": ${trackId}`
                }
        */
        raw += "}";

        var requestOptions = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8088/user/edit", requestOptions)
            .then(async response => {
                    window.location.href = response.url;
            })
    };