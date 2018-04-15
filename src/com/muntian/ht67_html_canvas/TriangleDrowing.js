"use strict";


let example = document.getElementById("example"),
    ctx = example.getContext('2d');
example.width = 640;
example.height = 480;

let count = prompt("Enter a number of section.");
drowComplexTriangle(count);

function drowComplexTriangle(count) {

    if(count===0){

    }

    let center = example.width / 2;
    let marginTop = 15;
    let partsHeight = 20;
    let indent = 5;

    let partsNumber = count;

    let x1 = center - partsHeight;
    let y1 = marginTop + partsHeight;

    let topBaseIncrement = 2 * partsHeight + 2 * indent;
    let topBase = 0;

    for (let i = 0; i < partsNumber; i++) {
        if (i === 0) {
            drowTriangle(x1, y1, partsHeight);
            x1 -= indent;
            y1 += indent;
        }

        topBase = topBase + topBaseIncrement;

        drowTrapeze(x1, y1, topBase, partsHeight);

        x1 = x1 - partsHeight - indent;
        y1 = y1 + partsHeight + indent;
    }
}

    function drowTriangle(x1, y1, height) {
        ctx.moveTo(x1, y1);
        ctx.lineTo(x1 + 2 * height, y1);
        ctx.lineTo(x1 + height, y1 - height);
        ctx.closePath();
        ctx.stroke();
    }

    function drowTrapeze(x1, y1, topBase, height) {
        ctx.moveTo(x1, y1);
        ctx.lineTo(x1 + topBase, y1);
        ctx.lineTo(x1 + topBase + height, y1 + height);
        ctx.lineTo(x1 - height, y1 + height);
        ctx.closePath();
        ctx.stroke();
    }
