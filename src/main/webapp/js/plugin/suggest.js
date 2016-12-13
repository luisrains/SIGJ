$(function() {

   suggest = $('#ms').magicSuggest({
        data: '/ventasis/abm/empresa/comboget',
        valueField: 'id',
        method:'get',
        displayField: 'toString',
        selectFirst:true,
        required:true,
        maxSelection:1
    });

});
