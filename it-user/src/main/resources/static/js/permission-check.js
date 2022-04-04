function isContainPermission(permission, pno){
    var permissions = permission.split(",");
    for(var i=0;i<permissions.length;i++){
        if(permissions[i] === pno){
            return true;
        }
    }
    return false;
}

function fillPermission(rolePermissions){
    var permissionInput = document.getElementById("table").getElementsByTagName("input");
    var isAllWrite = false;
    var isAllRead = false;
    var canUpdate = false;
    for(var i=0;i<rolePermissions.length;i++){
      var index = parseInt(rolePermissions[i]);
      if(index === 16){
        isAllWrite = true;
        continue;
      }

      if(index === 17){
        isAllRead = true;
        continue;
      }

      if(index === 7){
        canUpdate = true;
      }
      permissionInput[index-1].checked = true;
    }

    if(isAllWrite || isAllRead){
      if(isAllWrite){
        document.getElementById("all-write").checked = true;
      }
      if(isAllRead){
        document.getElementById("all-read").checked = true;
      }
      for(var x=0;x<permissionInput.length;x++){
        if(permissionInput[x].getAttribute("class") === "1" && isAllWrite){
          permissionInput[x].checked = true;
        }
        if(permissionInput[x].getAttribute("class") === "2" && isAllRead){
          permissionInput[x].checked = true;
        }
      }
    }
}

function leftPermissionCheck(permission){
    var permissions = [["character","8"],["category","13"],["mode","11"],["movie","4"],["show","6"],["field","2"],["order","14"]];

    for(var x=0;x<permissions.length;x++){
        if(!(isContainPermission(permission, "17") || isContainPermission(permission,permissions[x][1]))){
            document.getElementById(permissions[x][0]).style.display = "none";
        }
    }
}