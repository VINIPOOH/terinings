$(document).ready(function () {

    $( ".admin-option" ).hide();
    $( ".moder-option" ).hide();
    $( ".speaker-option" ).hide();
    $( ".user-option" ).hide();

    $.ajax({
        url: '/api/users/myRoles',
        type: "GET",
        success: function (result) {
            console.log(result);
            enableElements(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
});

function enableElements(roles) {
    roles.forEach(value => {
        let role = value.toLowerCase();
        let className = '.' + value.toLowerCase() + '-option';
        console.log(className);
        $( className ).show();
    });
}
