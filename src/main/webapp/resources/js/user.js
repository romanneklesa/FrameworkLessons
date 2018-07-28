function run(parent){
	$.get("/accounts?id=1",function(data){
		var html=""
			data.forEach(function(item, i, arr) {
         		html= html +
         			'<div class="form-group">'+
         				'<label class="col-sm-4">Account № ' + item.id + ':</label>'+
         				'<div class="col-sm-2">'+
         					'<label class="text-primary col-sm-2">' + item.amount + '</label>'+
         				'</div>'+
         				'<label class="col-sm-1">$</label>'+
         			'</div>';
         	});

         	parent.innerHTML=html;
	});
}
     
$(document).ready(function(){    
	var parent=document.getElementById('parent');
	run(parent);
})
