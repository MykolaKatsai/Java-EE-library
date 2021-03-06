$(document).ready(function () {
    $('#create-book-form').submit(function (e) {
        e.preventDefault();

        console.log("ajax POST coming");

        $.ajax({
            type: 'POST',
            url: '/rest/book/add',
            dataType: 'text',
            data: JSON.stringify({
                title: $(this).find('[id=title]').val(),
                isbn: $(this).find('[id=isbn]').val(),
                author: $(this).find('[id=author]').val()
            }),
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json')
            },
            success: function (response, status, xhr) {
                console.log(JSON.stringify(response));
                getAllBooks();
            }

        });
    });

    $('#get-books').click(function () {

        $.ajax({
            url: '/rest/book/all',
            success: getAllBooks()
        });
    });

    function getAllBooks() {
        $('#response-result').empty();

        $.ajax({
            url: '/rest/book/all',
            success: function (response) {
                response.forEach(function (book) {
                    $('#response-result').append('<tr><td>' + book.title + '</td><td>' + book.author + '</td>' + '<td>' + book.isbn + '</td></tr>');
                })
            }
        });
    }
});