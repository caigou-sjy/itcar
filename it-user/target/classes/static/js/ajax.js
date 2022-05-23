function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}


function ajax(url){
  $.ajax({
      url: url,
      type: "GET",
      dataType: "json",
      success: function(data){
          var info = data.info;
          if(info === "SUCCESS"){
            window.location.href = getRootPath()+"/admin/category/show";
            return ;
          }
          var categoryInfo = document.getElementById("category-info");
          categoryInfo.innerHTML = info;
      }
  });
}