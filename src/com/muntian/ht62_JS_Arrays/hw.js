function array_clone(arr) {
	return arr.concat();
}

function summ_kv(arr) {
	let summ_kv = 0;
	for (let i = 0; i < arr.length; i++) {
		summ_kv += Math.pow(arr[i], 2);
	}
	return summ_kv;
}

function unique(arr) {
	for (let i = 0; i < arr.length; i++) {
		let changed = false;
		for (let j = i+1; j < arr.length; j++) {
			if (arr[i] == arr[j]) {
				delete arr[j];
				changed = true;
			}
		}
		if(changed){
			delete arr[i];
		}
	}
	let result = [];
	for(let k = 0; k < arr.length; k++){
		if(arr[k] != undefined){
			result.push(arr[k]);
		}
	}
	return result;
}
