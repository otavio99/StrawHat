
function loadList(data, func){
	 render.bind(app)`
		${
			data.map(
				item => func(render, item)
			)
		}
	`
}

function getFormDataAsObject(context){
	data = $(context).serializeArray();
	var obj={};

	for(var key in data){
		obj[data[key].name] = data[key].value;
	}

	$(context).trigger("reset")

	return obj;
}
