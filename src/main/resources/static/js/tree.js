$(function() {

	var treeData = [
			{
				"id" : 1,
				"text" : "element1",
				"children" : [ {
					"id" : 11,
					"text" : "element11",
					"children" : [ {
						"id" : 21,
						"text" : "element21",
						"children" : []
					}, {
						"id" : 22,
						"text" : "Japan",
						"children" : []
					}, {
						"id" : 23,
						"text" : "Mongolia",
						"children" : []
					} ]
				}, {
					"id" : 12,
					"text" : "Japan",
					"children" : []
				}, {
					"id" : 13,
					"text" : "Mongolia",
					"children" : []
				} ]
			} ]

	$('#treeview').tree({
		uiLibrary : 'bootstrap4',
		dataSource : treeData,
		iconsLibrary : 'fontawesome'
	});

});