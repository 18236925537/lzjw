<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>http请求</title>
		<script src="jquery-2.1.1.min.js"></script>
	</head>
	<body>
		<input type="text" id="input" />
		<select id="select">
			<option>GET</option>
			<option>POST</option>
		</select>
		<button id="btn">
			发送请求
		</button>
		<script>
			$("#btn").on("click",function(){
				var method="GET";
				    method= $("#select").val().toString();
			   console.log(method)
			   var url = $("#input").val().toString();
			$.ajax({
				type:method,
				url:url,
				dataType:"json",
				success:function(res){
					console.log(res);
					alert(res);
				},
				error:function(er){
					alert(er);
				}
				
			});
				
			})			
		</script>
	</body>
</html>
