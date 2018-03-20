$(document).ready(function () {

    let fields = [];

    let bombCount = prompt("Enter quantity of bombs");
    let usedBombs = 0;
    let rows = prompt("Enter quantity of rows");
    let cols = prompt("Enter quantity of columns");

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

        // for(let i = 0; i < rows; i++){
        //     for(let j = 0; j < cols; j++){
        //         let point=0;
        //         if(fields[i][j]!==1){
        //             for (let i = 0; i < 9; i++){
        //                 if(fields)
        //             }
        //         }
        //     }
        // }

        console.log(fields[1][1]);
        console.log(fields);

    }

    start.click(function (e) {

        e.preventDefault();


        if (gameDiv.find('table').length) {
            gameDiv.clear;
        }
        fillFiled();

        //document.createElement('table')

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
        gameDiv.empty();
        gameDiv.append(table);

    });

    $(document).on('click', '#game table td', function (e) {
        e.preventDefault();

        let x = $(this).attr('data-x');
        let y = $(this).attr('data-y');

        $(this).text(fields[x][y]);

        gameDiv.find('table td[data-x=' + x + '][data-y=' + (y - 1) + ']').text(fields[x][y - 1]);

        gameDiv.find('table td[data-x=' + x + '][data-y=' + (y + 1) + ']').text(fields[x][y + 2]);

        gameDiv.find('table td[data-x=' + (x - 1) + '][data-y=' + (y) + ']').text(fields[x - 1][y]);

        gameDiv.find('table td[data-x=' + (x + 1) + '][data-y=' + (y) + ']').text(fields[x + 1][y]);

    });

});