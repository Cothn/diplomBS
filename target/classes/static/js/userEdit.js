
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