function login(){
    alert("Estou a entrar na funcao login...");

    var email=document.getElementById("emailId").value;
    var password=document.getElementById("passwordId").value;

    if(email=="" || password==""){
        alert("All fields must be filled!");
        return true;
    }

    const url = 'http://localhost:6868/login/check';
    if(email!=null){
        $.ajax(url,{
            type:'POST',
            data:{email:email, password:password},
            success: function(data, status, xhr){
                var obj=JSON.parse(data);
                if(obj.state==true){ 
                    localStorage.setItem("email", email)
                    localStorage.setItem("firstName", obj.firstName)
                    localStorage.setItem("lastName", obj.lastName)
                    window.location.href="http://localhost:6868/client/home";
                    alert(email)
                    return true;
                }else{
                    alert(obj.error);
                }
            }
        });
    }
    return false;
}