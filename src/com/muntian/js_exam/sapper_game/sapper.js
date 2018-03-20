(function program() {

    let fields = [];

    let bombCount;
    let usedBombs = 0;
    let rows;
    let cols;

    //Enter of input data
    while (true) {
        bombCount = prompt("Enter quantity of bombs");
        rows = prompt("Enter quantity of rows");
        cols = prompt("Enter quantity of columns");
        if (rows * cols <= bombCount || rows === 0 || cols === 0) {
            if (!confirm("Incorrect input. Unacceptable number of bombs")) {
                window.location.replace("TheEnd.html");
                return alert('Good by!');
            }
        } else {
            break;
        }
    }

    $(document).ready(function () {

        let start = $('button');

        let gameDiv = $('#game');

        function fillFiled() {

            for (let i = 0; i < rows; i++) {

                let field = [];

                for (let j = 0; j < cols; j++) {


                    let value = Math.round(Math.random());

                    if (value && usedBombs < bombCount) {
                        usedBombs++;
                    } else {
                        value = 0;
                    }

                    field[j] = value;
                }

                fields[i] = field;

            }


            // console.log(fields[1][1]);
            // console.log(fields);

        }

        //Event of click by button start
        start.click(function (e) {

            e.preventDefault();

            //Fill fields of by values
            fillFiled();

            //Creating of game field using table
            let table = $('<table/>');

            let tr = $('<tr/>');

            let td = $('<td>');

            for (let i = 0; i < rows; i++) {

                let fTr = tr.clone();

                for (let j = 0; j < cols; j++) {
                    let fTd = td.clone().attr('data-x', i).attr('data-y', j);
                    fTr.append(fTd);
                }

                table.append(fTr);

            }

            /*for(let i=0;i<cols;i++) {
                tr.append(td.clone());
            }

            for(let i=0;i<rows;i++) {
                table.append(tr.clone());
            }*/

            //Preventive cleaning of gameDiv
            gameDiv.empty();
            //Insertion of a game field into gameDiv
            gameDiv.append(table);

        });

        //Event of click by squares
        $(document).on('click', '#game table td', function (e) {
            e.preventDefault();

            //Get coordinates from data-attributes of a square
            let x = $(this).attr('data-x');
            let y = $(this).attr('data-y');

            //Display content of a square
            $(this).text(fields[x][y]);

            //Display content of adjacent squares if they haven't mines
            if (fields[x][y - 1] !== "1" && (y - 1) >= 0) {
                gameDiv.find('table td[data-x=' + x + '][data-y=' + (y - 1) + ']').text(fields[x][y - 1]);
            }
            // if (fields[x][y + 3] !== 1 || y < rows) {
            //     gameDiv.find('table td[data-x=' + x + '][data-y=' + (y + 3) + ']').text(fields[x][y + 3]);
            // }
            // if (fields[x - 1][y] !== 1 || x >=0) {
            //     gameDiv.find('table td[data-x=' + (x - 1) + '][data-y=' + (y) + ']').text(fields[x - 1][y]);
            // }
            // if (fields[x + 2][y] !== 1 || x < cols) {
            //     gameDiv.find('table td[data-x=' + (x + 2) + '][data-y=' + (y) + ']').text(fields[x + 1][y]);
            // }
        });

        function displayAll() {
            for (td in gameDiv.find('table')) {
                td.text(fields[td.data.x][td.data.y])
            }
        }

    });
}());