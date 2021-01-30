var url = "http://localhost:8080/store/food?page=0";
function loadperson(){
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open("GET",url,true);
  xmlHttp.setRequestHeader("Authorization","Bearer eyJhbGciOiJSUzI1NiJ9.eyJjbGllbnRfaWQiOiJpc29maCIsImlkIjoxLCJ1c2VyX25hbWUiOiJhZG1pbiIsImZ1bGxfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BdXRoZW50aWNhdGVkIiwiUk9MRV9VbmF1dGhlbnRpY2F0ZWQiXSwianRpIjoiNWY0MWVkZDEtYWQxYy00NWNlLTkxZmMtMmIyYWY0ZmNkODI3IiwicGhvbmUiOiIwOTEyMzQ1NiIsIm5hbWUiOiJOZ8O0IFF1YW5nIEhp4bq_dSIsInVzZXJuYW1lIjoiYWRtaW4iLCJpYXQiOjE2MTIwMTQzOTQsImV4cCI6MTYxMjA3NDM5NH0.kdBMFuqtat1rn7K5TFccbMDdrgwUFjR55-D_OT01T02frWjjZOiLsApabuItlirlFLIyrnJFR1TLMXHC2rvR0L6ZMPmREP5Kdf1HXdzw_m3sw7_SIDUbTdSrs2XEIEzBg1U9unkhGkJd8mRaw0wUBxUN2QX8CgzPVzcs5W3FOcByEvQHK859kMuQuPTmV7u2ZcBo2kAJUV-UJWRxpDazxZTk7XYKjzAiHW279C_7LbNTPo7aNA0rJLfr5sKsFlscG8KNueG5G45Ez1U7YV1DN7PWi9PXX7Xv58vhvSvXNxEHm_-8l5lnpGRMccZqHY89wsGGuU5aa5DCdYFQ5UDgwg");
  xmlHttp.onreadystatechange = function (){
    if (xmlHttp.status === 200){
      var data = JSON.parse(xmlHttp.responseText);
      var main = '';
      for (i = 0;i<data.data.length;i++){
        main += '\n<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 ">\n'
            + '<div class="offer-item">\n'
            + '<img src="images/menu-item-thumbnail-0'+(i%9+1)+'.jpg" alt="" class="img-responsive">\n'
            + '<div>\n'
            + '<h3>'+data.data[i].name+'</h3>\n'
            + '<p>\n'
            + 'mon ngon.\n'
            + '</p>\n'
            + '</div>\n'
            + '<span>'+data.data[i].price+'</span>\n'
            + '</div>\n'
            + '</div>\n'
      }
      document.getElementById("informationFood").innerHTML = main;

    }
  }
  xmlHttp.send();
}
window.onload = function (){
  loadperson();
}