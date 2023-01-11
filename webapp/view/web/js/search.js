
function search(e) {
	//e.preventDefault();
	var content = prompt("Nhập tên món ăn cần tìm");
	console.log(content);
	$('#Foodd').val(content);
	var data = document.getElementById("Foodd").value;
	$.post("/garanweb/search", data, function() {
		$('#Foodd').val(content);
	});
}

