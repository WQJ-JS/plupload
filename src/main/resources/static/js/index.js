/**
 * js引入文件
 */
$(function() {
	function uppds(n){
		$.post("/uppds", {
			"n" : n
		}, function(data, status) {
			var html;
			data.forEach(obj=>{
				html +="<tr><td>" + obj.id + "</td><td>" + obj.name + "</td><td>" + parseFloat(obj.price).toFixed(2) + "</td><td>" + obj.desc + "</td></tr>";
			});
			$("tbody").html(html);
		});
		/*$.post("/uppds", {
			"nsrsbh" : nsrsbh,
			"nsrmc" : nsrmc,
			"ywbw" : ywbw
		}, function(data, status) {
			var html;
			data.forEach(obj=>{
				html +="<tr><td>" + obj.id + "</td><td>" + obj.name + "</td><td>" + parseFloat(obj.price).toFixed(2) + "</td><td>" + obj.desc + "</td></tr>";
			});
			$("tbody").html(html);
		});*/
	}

	uppds(10);
});
