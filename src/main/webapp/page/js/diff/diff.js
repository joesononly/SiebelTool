$(function(){
    $('#example').DataTable( {
        "processing": true,
        "ajax": "/diff/queryBsByName",
        "columns": [
            { "data": "lastUpdateBy" },
            { "data": "lastUpdateByCode" },
            { "data": "lastUpdate" },
            { "data": "name" }
        ]
    } );
});