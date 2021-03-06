let numberAuthors=0;
let numberPerformers=0;
function addAuthor(){





    var authorsEl= document.getElementById('authors-group');
    var authorName = $.trim($('#authorAdd').val());

    if (!(authorName === "")) {

        numberAuthors++;

        if (numberAuthors === 1){
            authorsEl.removeChild(document.getElementById('authors-zero'));
        }

        for (let i=1; i< numberAuthors; i++){
            var temp= $.trim($('#author'+i).val());
            if(temp === authorName){
                return;
            }
        }


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

    if(nodeElId === 'performers-group'){
        numberPerformers--;
        if (numberPerformers === 0){
            let div = document.createElement('div');
            div.className = "input-group mb-2 col";
            div.id = 'performes-zero';

            let inputBlock =
                '<input type="text" class="form-control" ' +
                'hidden ' +
                'required ' +
                'id="performer' + numberPerformers +
                '" name="performers' +
                '" aria-describedby="delete-performer-btn' + numberPerformers +
                '"/>';

            div.innerHTML = inputBlock;
            authorsEl.append(div);
        }
    }
    else {
        numberAuthors--;
        if (numberAuthors === 0){
            let div = document.createElement('div');
            div.className = "input-group mb-2 col";
            div.id = 'authors-zero';

            let inputBlock =
                '<input type="text" class="form-control" ' +
                'hidden ' +
                'required ' +
                'id="performer' + numberPerformers +
                '" name="performers' +
                '" aria-describedby="delete-performer-btn' + numberPerformers +
                '"/>';

            div.innerHTML = inputBlock ;
            authorsEl.append(div);
        }
    }

};

function addPerformer(){


    var performersEl= document.getElementById('performers-group');
    var performerName = $.trim($('#performerAdd').val());


    if (!(performerName === "")) {
        numberPerformers++;

        if (numberPerformers === 1){
            performersEl.removeChild(document.getElementById('performers-zero'));
        }

        for (let i=1; i< numberPerformers; i++){
            var temp= $.trim($('#performer'+i).val());
            if(temp === performerName){
                return;
            }
        }

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

async function addRating(rating, id) {

    let response = await fetch("http://localhost:8088/rating/edit?audiobookId=" + id+ "&rating=" + rating);
    if (response.ok) {
        let newRating = response.text();
        let ratingEl= document.getElementById('rating'+id);
        ratingEl.textContent = (await newRating).toString();
    } else {
        alert("Ошибка HTTP: " + response.status);
    }


}

function sortBooks() {

    let url = document.getElementById('sortForm').value;
    let sortBy = document.getElementById('sortSelect').value;
    let ascending = document.getElementById('ascendingSelect').value;
    let fullUrl = url+"&sortBy=" + sortBy+ "&ascending=" + ascending;
    window.location.replace(fullUrl);

}


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