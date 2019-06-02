$(document).ready(function () {
      
    const $coll = $('#collapser');
    const $tBody = $('#test').children();

    $('#basic').simpleTreeTable({
      collapser: $('#collapser')
    });
    
    $coll.trigger('click');

    $tBody.each((i, e) => {
      tmp = $(e).children().eq(0).html();
      let c = tmp.match(/<\/?[^>]+(>|$)/g)
      c.unshift(tmp.replace(/<\/?[^>]+(>|$)/g, ""));
      
    });
});