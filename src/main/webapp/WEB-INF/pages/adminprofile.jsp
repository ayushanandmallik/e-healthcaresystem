<%@include file="head.jsp"%>
<%@include file="adminnav.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if(session.getAttribute("users")==null){
	%>
	<c:redirect url="/adminlogin" />
	<% 
	}
%>


<div style="display:flex; flex-direction:column; align-items:center; justify-content:center;">
    

<h2>${msg }</h2>

<style>

button{
	margin:10px;
	width: 150px;
}

</style>
 
 
<div style="display: flex; margin:150px;">
<div class="card" style="width: 18rem; margin:10px;">
  <div class="card-body">
  <img class="card-img-top" src="https://assets-global.website-files.com/5c126c47201a857b9cfbf40c/5c58a8ac9c0fd5542fef5c93_shutterstock_223785532.jpeg">
  
  <p></p>
    <h5 class="card-title"><b>HR FUNCTIONS</b></h5>
    <hr />
    <p class="card-text"><i>Add new wards, new departments or new doctors here</i></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><a href="addward">
<button type="button" class="btn btn-info">Add ward</button></a></li>
    <li class="list-group-item"><a href="adddepartment">
<button type="button" class="btn btn-info">Add department</button></a></li>
    <li class="list-group-item"><a href="adddoctor">
<button type="button" class="btn btn-info">Add doctor</button></a></li>
  </ul>
</div>

<div class="card" style="width: 18rem; margin:10px;">
  <div class="card-body">
<img class="card-img-top" src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBYWFRgWFhUYGRgYGiEcHBocGBgYGRwYGBoZGhgaGhocIS4lHB4rIRoYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QHxISHzQrJCw0NTY0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NP/AABEIALcBEwMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAEAAIDBQYBBwj/xAA+EAACAQIEAwUFBwIFBAMAAAABAhEAAwQSITEFQVEGImFxkRMygaGxI0JScsHR4RTwBxZigpIVJDTSM6Ky/8QAGQEAAwEBAQAAAAAAAAAAAAAAAQIDBAAF/8QALBEAAgIBAwMDAwMFAAAAAAAAAAECESEDEjEEQVETUqEiYbEyccEUI0KR8P/aAAwDAQACEQMRAD8A9NYxvQOL4oFEIuY+OwoXF32OZzpBIUeA3PmTp8Kq0cltef8AcVdIxbaCxjrhOaRP5RTRPOp0UEbf30om3ZUiRRsKiCoKmCU57ETHKkhoDDrZinX7ciRSinq0UAkLAMpB56GqHAHJcfDH89vxQ+8vwPyNaRkB1GhrM9rcMwFu8hyvbfQ8u9yPgSI+NdZ1FwtNuW5iNDy6EdDTMBiVuorroT7w/C/MUTREaIk6EadOh8KKtoAuYb+PIfvXbOFmCw/eiRhyTJJA/CIj6UGFY5EiMyKFOUczz32AokCBApDSkaKVCylYjTTXTTSaY44xqMODsRQnG83sHyaNlMecV5x2YwuLTE2muuxRgZBckeGlFIW8npF7esnxg/aVrLx1rI8ZP2lNHkE+BimisPeAQig0GlORauQrIZZu670arg1VKNaJVyDSNDRZrOGYS2bQbKCZMncjoKbeQLvAHpUHBsXlsucpYhtAup1AoDF4u48B7ZRZ0msztSZqw4os+6YEipsdhU9kSVAPI85qpu3QhVxEjr5VHiuMO65TkA38frXW8BpUwS/Y0quuWtD4U+5i2J1ceoqtXEYgWL+SWT2ilzlUBUzbgzJMVT1KJenZOiajzH1p/EwfavHJyOnORVW3E7WveuHX8YH0FRniqMWINwyZOs6+cUXqJgWk0WmU9T60qqv+pr+G56/xXaG9B2M3HE7ssFGwA9d6itpsaYdWmiEWk4H5CEMGeR3/AHohHyNPI71CgqZ0lSOYoDBV9YYEdKd7NWExrUdl89tW6aU+20GlHONagSNfCoyRGpAHjpRxHMVgv8R8QyNaABVSrd4HQtIkeECPWmirdE9WWyLaVk2J7Qq+Ltoj5bSHvvmARtJJJ6DbXStNicOHXYOpGxAII3BFeR8D4f7a6XdWa1bUMwAOUmY7x5gaGB+les4PiKBMzuAgE5jsoA5+FNPtRLQbdtvn4K/DYJLbE2iEnQ2zorHUiPHerv2YCgxqRtNeZY7t2MRcu+wtsXTuYfQFVBDC5iHnTMe6Fmconqa52X7OXHvi7fuOzBg0q7Zs0zqx+74CK6MHJWPPUjB1J5Z6a7mJmPpXbeLB0g/DauXMKWOp+HKprGGAoWkhmm2PzUpoeDmNPD11gcaHmmk1zNXJogKbtdimt4W467hTFeTdn+NXjicPmdmBaIPjXo3+IuNyYRxE5+7614/g8R7N7VyJyMDHxrpOqBFXZ77dPPwrJcYf7StJhsRnRHH3hWP48/2op48iy4CUcdakDjrVej6U/NVyAerid667id6AR9RT7j60KDZruzWIK2rpVS5BBgb7VBicXdcw1sqJmJFF9jiv9PcJ3LHz0UVBcZ0ILsuUmPfSdp28qyyrc7Zqje1A1+4GKh0OXSZgipeLYBfZqy2lOY8goMRXeIcRR0QBhvE6GSOVE4ohcGT95SIneCfpFKqbSC3yZG5wtzMWQB+ZRVZieHXwjqM4D7or90x+Ic60drHEjWuOZFW9NdyXqPsY5OFHL3i4bMQwCaBANGDTqTrpWyT/AOHIoRkGUC4ECMyptmjczzqAVY4onM48Z+lFQUQObZX5fAfKlU3sZ5fM12npCWG2liKLQVFZWRUqCKzs0oJtaGp8uU/TyqPJAB5GiFGZfFfpzFKxkR8PSFdOjGPKcw+tSUsCe+w6x8x/FOIoB7BFtqqO13CRiMM6x3k76How3+BE1aAd2p7TTpXJ07OlFSTizx7hV97GbKYnRlP7VBxLFXrqtYRStl4LMZAAmSqjnsPWvTLeGw6Yh0u20JIzISoOm8fUfCsPdv8AtGZ2OpJgdBOgHQCtsFHUxR42rKXTfUnbdqvBX8PwKWVhVjmTuSepNWvDONOTcRJJZcuYaBOpnrE+tDAU29fyLzA8B+29aHprbXYwR1Zbtztt/c9D7NELbVcwj3RJ+8OQ+elXUVgez94v7NGGVQxZQTLFiN28Y5Vt8DjEuqSjTlJU9ZUwawa0GpWe70WspRUfHH8jWSCahSi3GtDsutRs2ND1TeoZom0Nqo+03EThrL3AJK8qeOcE5qsma/xT/wDGH5hXkl09xfMfWtP2l7WvikCMgUTOmtZllBAHIV02nVHQTV2e48Eb/t7f5RWQ7TYtFuiTVHb7Y31trbWAFETzqhv4pnYsxJJ512+uAbL5NZiOM20XeTGgFUf+YX9oCTCzGWqK8GLALqTVzwns8xYNc05xTqcpOkI4QirkzZ4e5mgjnU1zeobKxAHKpbu9aGjOmazstiPsHTmXnbkVA/Sqt7GQsGURmJkiTIJ50BgMW1tpU76EciK0Rsl7YuAgq3PmD0bxrFrQpuT7llKUkkuxD2cwKszNGgeQI2kVY8axNoWLqT3jlgbw0zHhprQ2DZ7SPGUDcsdYHwrOAtccqgLSSfEk7k+NLox3O1wguTXPLIwYo1T3aY3Cr34KJu4G4iAupArW5IRRYKDpWlv4Xvkx7yg/36VmM2hreMvun/QPpSakqoppxuyh9h4V2jQTr5n6mlU9zH2oFS3l0o5sL3A2onaRvUFskmTV3xE/ZJ8P/wA0smPGOGV2EIIKnn8jUiAo2tQLR9xcyA8x9KDCgSwYvkRplUg/FwR9PWprvvHzqAP3x5E+hX96Jv7zXHLgltiVpW6bhjyqh7Vce/p0yprccEA8lHNvFugoxi5OkCc4wjuZXdveK21e2EcG+hOYAzlU6gMdpnlvWK/qBnLDRWMxyBO48qq8RIJJJJJkk7nNrJPOuJdrbp/QqPJ1v7rb7M1KsI3qNroGsVTYPEawT86sRcFaYytHmy0dronwuMYNKA+0HusRCp1Yk6EgbAc/KvQOyWHCWxJGZ5IE6lFgFvHUjXxrzlrqgFnfKi6sx+QA5seQFVmA7YOcSlwSqooS2pM5VE+91zSc3n4Vl16eLyz0uhg73Vhfk9zu70x0qHB4oXkS4ojOsxvB2YTzgyJoxUrDwezyMsrWT/xF/wDFu+X7VskFZvtjhfaJkPuusHzBpoPIuosHgDVyt3f7FoqEiWI2FUydnGLAeyYa121i7kZ6uQdgJr0A9irQWZM0DjOCJaZIO9FQbA5JFXwXhDhwzDStMFpWhoKfWuMVFUjHNuTtjk3FPvHWo1OtXfZ/hAxFxg05UWTHMnYT610pJK2dGLbpFRbq+7PYnKzqT3cheIJGZR08qsMFwqyzOvswAumszvpVhheF2kzZV1YRJkmOY1qM5RaaLQg7so+M3S9pCsy7EMoGkASIjzoXs1cKYgAr7wjUQetbJMMAoywOX6V2/wAIRnR9AybEHcdDUozSjVFfTd2ghl12qHiNlXCoRInUbbUU4gxUSCXgdKReSrXYyPaDAqlzJaQjuidS0ltonatphrAKITvkA+VC3sP9qDEnT9qPvSI5aUZStJHRjTbK5sKknzP1pVW4otnb3jr0Nco0LuXgjsNV1xlwLaRtI9IqntjSatcencT++VB8hjwyvS4DVnZICqDswqsNnpRVpiVjpqP1FczlgZcSHAO4kfKf0p5frUF5mZ1PIAz6QK5RoFkmcnQaA1nO2mCzWVcDVG1/K+nyMVoqZicMtxHRtnUr5SNDTQltkmT1IboNHj1+3Ijny/aqq5IPStDfw5UspWGUkMOjDQ0Fdw4befMf3rWuSvKPLhPa6YHhVLEASSeQ3ra8P7HYtwoZFRTHeZoMflEmrPsF2WC/9w4B5oCIPmVr0AGoS1nHEeTZpdNHVVy47GM7T9gLd7CLZtMVuWyWQsTlZiO8rjkDyPLymvH+Gdn8RcxBw+RkdGyuWEC3B1LHr0jfSOtfSqNyNAcZ4ULygg5HX3X/AEbqPpUFJt5N2xRjUUO4TbRLaImi20VAOcIAAT4mKMA0rM4LF3LL5LqhSR1BDAaEr4fvWls3QyyNqElR0ZXgSb1n+2mMSzaW45hQ8T+YaTWjRKpe1fCxicHesmJde6TydSGU+ooReRpK0ea3+3NgaKCxqvudtXZsqWtTtNLF/wCHdy3bL+0BYawBXOC4YKZRMzqNSfCrpNrJnbSeArCcWxDOBeUopNG9oSMyRtQdnEteY+0EEHloBUnElJCydV+lPFYJzZ21tT6it7U41WySRIm4rQ9m+MLh7jZpyOsEjkw90/M0N2Y4RbxBfO5XJEKpAYzz225aUViuCqrkBCwG3f8AmdqnKSdxZSKcakixw/GLYZmLDvmSZ2ieVH8P4rbuuUXMCBOo0I51S8M4EjXArAwd4fbTwNE8IwqJjHW2cyoh1J1B0zDlJGtTkolIuXyW3EMcloJnYgPMECYjrQmH48r37a29RqXJESYiB9an4rglu27Z6OwnnGsfShcHw5LbhxEjSkVUO914NDZuh7pEQAoPzpmNxaq6gDUMQSBEaHTxoWxiMrF43EUPiHzNm/1TS1ko5Oi+sIDDEmTUt1QYB2/iqROIRTrvFCWHh+opdrDvSRmeNIq3nVcwAj77/hHjSojGLndmJGv7UqupIyuLJsGxjXarnFYmVSYAG/pVBhrjEkEAAeNWbQyrOsUjRZPBLnSJBMetRC5NRO0mPWuE0KDZPmpvtAN6gZ/hTHM11AsOV5p6+tQYW3Ak0cqaSBFBjLJlO0/Bgzi4vdLjX8y6fMRUHZ7s27ur3FARTP5j4DlWtv2Q6xvlOYfD+/lU+ESFj4061ZKNIlLptOUlJrP5HK2Uxy5USeo250PeWRXcNc5VIusYJZqRGrj2+Y2riGuGBeJ8PW8mVpEGQywGU8ypNVWHxD4ZxbuHMje6/UdD0Ycxz3FaAUzF4NLqFHEqfUHkynkR1rlLsxHG8rkmtsCJBkcqHvaqQOhqrwrXLDexeWVpyPG/OGjYiraxEUaoKd4KO5qD5Vjr1xLTyQAGJrScX4rZw7lLjhTOg5wdRWcfiWCZ87XAegO1XjJJMyyi20V3BGLYl1CnI2sxpPhTOO4QI+hJmrs9pcIp7rKPIVnOOcatOwKtNDcM4kls6UThrGarzhXCcPcs2nQli6gtBzQeYOoy86Ifh1m2wC5yOcMPLSadSTE20LsZYK4lz0tn1LJA8z+lQcbuj2rAHUMc3nFWjsiWHCIwLnqc2bUqZG+gkVQ3wjspUkswzMTmnbQwf08aXl2N/jRd8BJW8gk+98ss603s8rHFYgrv3vUuak4NbVL6gmRmiTzlRH1qTs8MuNvr1kj/AJT+tCT5/YaK4/cs71llsKCTmDmeneBrHPxB1vCTIDiR1E7Vv+K+4v5/0avN8fpeP5h9aGnm7Dq4o9GTGIpVsu/gJqj4pi893ujKO6PPeSaIu3IRDFU73PtAf9QoKK5BKbeCzaARJpcQIUoRzgfKocXeA3UGRvrNdxV4QmgOg38qZR7iSlyjL4zFPnbXnXaZjLnfbTnSrRSMm6Xk0Vs61Yu2VEIqosMatcaCttM0gHaRWVnoIjsPJY/D96jdzOn80sOYQeOvrTXNA4cprrGm2/AVOE+J+VccE4J5idhViHLCFGlA2SPhRqXxEbRSMeIPbQq2p2+lGJ4bULeJOoNdw+IE5SZrmFOgt9KiZI1FTgzoaiiCQdjQCyew81Jk1mgrLwaPUyKDGjkjK1ImwpqtOlOQaVwSPEju6UHafKdt6nx8aSY57xQr21ZSDJB6TPmCOdMhJc4MF/ib2We4Ti7EsygLcTeVXQOniOY5isfh+yOJdQ2Uaia9qw15UBV28ASD3gdNR1qg4tiHtXMiW8yEBlMx3T+1PFW6JTlSs8w/yric2XIPOhcdwS7bIBAr1osxALCJrJdpm7wptqF3spODYX2YJzEFt4kfSrJbooW2dKdNOsIR5N72ZvM2GZ2M5GKoTrGYLIHxP6VX4l5ujyj/AJEn5AgVYYdlw/D7Zb8JuN4liWUeeqCqDBuzMrNuSCemvL00pY9xnii5vjK6+GQ//VRTuL4xsNivaqoOdNjsQYOhFO4qBmXo1sfIfwKG7RNnw1p9ykKT8oPyo80B4bCrHaJsQQpRVCnNoSSSdOdZ7ijD2p8xUnZ4/aEeFWeMwFpXzXGLMdlBhR5kak1ySTwBybVstX1RO8B5g6+lVLgZ/eGjDTmfKrx3TKs5o0iIqrv4lc6jKND01oILJr1nMs5thtlY/QVEGzi2NtBrE7Tyov8AqAAQXKyOQBn1oFVWVg6DqBtNPHgnLkqsZZAdtefSKVHYpEzt3uf4B+1dprI0GO40CrrVpxC+1y0qsAIj4xVOr1OmKbY61nN1izaV0JO/pz/iuudJG9DLaafOjQLCUucgI8v1NGW1qKxaAqV7gFAYfMVz2lCvfpyKTvoPn/FdQLCPachPwqexgZ1Y/AH6moE00GlFWLsaUGMq7hWTpUy94Qaaj1IKRlECRBiisM/KkySSDz28DUBUqa7k7gJKgHeplqi40rjvIZMSV/ahuHcazISp2kEEQwYbgg7GjttA3U6LbE5Wc6Tl06xzNdZwoliAKhtXFVS7HYEk/WsdxjtCWciYA2HjTw03J0iOtrx01b7l7xLiFtFPvksCQQcuvI+enOaznCsa2Kv5ZljEyeSc/AeArKY3iChmZg7Npqr5QDt3gymaZheJKGU20a3cLGXDszgEa5YAGuo205VVVF7VyYpaktRbnx4N/wAQxzXL/wDT2WHs0EM0CWug97KeijTxM9KB7dcGCYdLonMGAYf6CD3j0gxr40LhOJ2cOqsvfuESqqQTPIHkqjmec+FOw/E71y4rXWDEkAg6IqsYKxzBGmu9O9NvC7E49So5ly+F4Rm7O1S27RdlQbuwUebEAfWiFsJLxIUO2UHcKGOUHxAiu4AAXAfwAt8VBj5xSpXg1ykoxcn2N32gwZdrdv2bNbRMxhTlJQQi+OuseArN4PA3swm2/L7jDUnyqq4hjmVT9pcDESIdwZ66Gq7CcRu5lm7cOoGrvtppvTei1izPHrIzW6mjf8Uwt1lssEcsFhgFJgiRrReGwTPgb1tkZWBLAEETGoIrC9s77g2SHcA2xs7DXmd96g7Ccca1cvozFgy90MS2p0P9+FTcXVF1qK22v+eDedlODqgVmP2jiTv3V/D59am4hwRHdnN7KJJPd0ABruAxTMgbQEzt0Bjf4VJiWUrlbY7+NTbe4ukttEr4dMgIeQNjG9VV3C2M4LXiG3gKas1y6AUy5aWdtT5UVI5pMFxduyAC1w/AUMl60syxgiNp9PGjXtIzBI1JgedRY6wluA4iRI1BrlLsBx7kH9Zhubt6UqiItHpXKbcLtQ5bYyyuppiZhuCKP4W6BA0jagOJ8XQGARNQUrQzdBuAsF23+FH4xQhAMTWaw3FwHVswGvWtXhLK4lSwYQDE76xNKptyHStY5Kq5iwOY9agOIBMFvnWT4zYYO4DEQTpQ9guyBs5zda3x0E1dmGXVSi2qN1bvIDGZQfOp1vp+NfUVgbBdknOc0706wzlTLtPWn/pl5E/rWux6Et9Pxr6ipVxCfjX1FedoHyGXYnzqXC2TlaWYmN52oPpV5OXWyuqPSLGKQaZwfjRhcQDy615jZRgnvtMjWTNWVnFXGZVLuVEaSY3qc+mrhlodY3yjfPeGmtMu4idIqBrZHPXyrnsj+L5VlpG7cxl59daz3FbeS6jqIDnK8ad4CUbz3HpWiezPPTT1NQYjAK/dbUAzr4bbUyEZR9o8eUtIsxmOviFH0mvOsfiSzE16vjOD2rhUuitpz3A8NdNyaEu9msLOtlJgnw8J11q8JxiqMetpSlK+x5EWLN3pIOh11jwPI1c2uKLbMYe0LZIgXGOe4ARGhiFPiK9EtdnsMDJs2xqNMimQYk6063wXDED7GzJUfcAEt8NOVB7W7YijLhYPKsPeynuqT1OgFaDhgDuoYkjcgaAeJHPzNbHE8DwyyRYt+9EBSDvGw+HrQ3E+F4a0BNlFB3OZ0XK05SSN/uz51RalIlLp3JpmZ4w6XLrOhEEKCV0DMognx2GvOncPshVduoCj/cZPyFR9pHS0lhrKIquGmGJOZSvInaCPnRGBecPbJ3ZmcjyML56An412krkN1ctui/vgpONtLEdB9aGw/vL4MPrTuJNNw+YHpFR221HnVH+pmaCqCNB23X7PDt/pIrP9m49u06SoA88wrT9sFnDWW6H/ANqzHZzL/VIrFQHlSWEgagz8IJqRtXc9XwAAtoJEhdudZnjuOf8AqIV4AgAdRrJ9a0GEUELBBjSd5jTeqXifD82IO0AgzMCp19Ro3XEt0xBVUO9VfF+JsHWUnX8TL9KuHtAopkDw/Ss9xhRmXSda5JM5tk2LxM5WI1J5MRFBcRYQC2cj8zkj0qzxVtCiEElpGkaT50FxSySAM6oAJLM2WBtpprRo6yo9snW56v8AtSokIDstKhsDuJMNcLIFDEHwrKcVtXUuyGOvWtlwywMw03q64h2fS4veFZNNWqDqNp2uTzzgt1Sr+1nNOn8eM1t+w/tlzkZzb+8BtPIn4dKGw/ZNM4VJ6mtT7RsMrKsBYkyNtImhhMdNtWzzLtVjXGIcIGCE7RPqaqUx15TlGaCemlWuP4orszFhJJqHD4y2EgsJ+derBfSsnmzll/SV64y+HCjNlza6U9MTfzlRmy5t4o6xjrYEFhM7c66nELcEZxM7VRJe4k5v2dvHyCJdvs0d4D5aU6x/UENq400oleJ24K59eldXjFrKe9tvXfT7g3L2fA7huGvF0zMwWZMmtl2e4iLaZH1YtoYnQnSsjZ4zaJABJnbStFwbAteCuphc3Ma6eFJPa45eCunuUrrJuUcxvSRjI1qNBT0GtYD0cji5mPGujY686ZGtPGxrjhW0Gb++YpBAZnXQfWu2z+ldQ11goelsaeX0pezGnnXQdB5GnDYeddZ1IGxKDTT+dajxKyASBsKmxJ0GvWm3QSAJGwHLlTJiNAPE8KroyFRDErMDTMYMdD41kOKhLYCJmyIoAJEbADT0+dazijuEdg40JYd0EddxyrE8Xui6cyMrSo7u2QxqkeBnUb71q0OTzutTa+1lLiyoYqw7wOsA778qgBTT3qje28+7TkC5ZdW03IMD6VSTrLXwThp3hP5Nn2ltocECAxAysPItr9axeExKowYLqPDWirOIttbKIbzLzAdivWCo+FNthEIlWVQeYMipwkuTTqQvH8mz4FdZWUAj2VwZkBnNr7wM+6wOkUT2mwZDo/IiP9w1+n0qo4JxSybuRXzLOkgyYjr4irTtBxxQQhYRodtZHjSNrdZWEZKFNZLfJ3VjwquxKgOSQNuYmrJL0ohGoMRWe49j1R8rAjSRpU00W2sONoHLA5jlRdvhy3LgLgMqrGUj7xO9DW7yG0rI2uhHj1o1uI27Vk3HcAga665uSgc+VNaoXa7ClwVs6wB/t6aUqx9ztspJjPSrrXkTbLwG9nbRZwCNta2F3KBWQwfGLVsElu8aC4h2jzTkBPrWSEWo5KyknKkbrgWTM7kgHYSeXOs52/43bylFMsRlkfOsseJsonMfKqbEBrjFmcyflTacLlcuBpzezagNeHoSCVmNqlXhqSCRqKlHD35PTv8Ap107XK3qUfBgcNT3fkanD0zTlE1Pb4cmbNAmuLwm/p9pROF4VdU965IplOPgV6Wp7vyQrw9AxYASedNOBVSYUCd6LucLck/aED6eVR3uDkzNx9eddvXZB9J1mX5O8MwwDqQug200rdcLaEWAeukVjuEcJ76r7R4g7MddK2HDrQVFAmAKlqytF9GO18lilw9G9RTxcadvnTbaaGkm9ZqNdkhc9PnXVcxt89qYN6eNjXHWdUk8h6muMT4eprto6n4Ugfp+tcA4F8F+dPA0+76V2dB8aWbQedcAivNAjSPy/WmPdgA6f8RUl/YaU2+oCDxH60yEdlVxd1dGBLSsgAEqNdNY3HgazXEbiCMiQqqBrrmYDvOeUk1tMbYUo/d111/4/vWYx2HVktuABnQSBsWAysY8SCfjWnRaTPP6tSa+xknxLHn6RQuLuMUYHNqCN6ssTYLMWPM7wNeXKo7mABB03FPKTp2waUcqkVHZ+66WniAc8lonkBH61e2eP5RDW1YxEwB8dqgwFpkt3bbAgOQRtGm8/CoW4YD95R8DUtKTjGkX6nTjOdtGg4O9u6+YAK3QLrmHQ+NWK8JuNic5RSmTduXWB1qm4PeW0VRQJJljufGD5CPia1b9oESFLCYml1HlNFOnhUGm3RqHxFsooCwVjSIgDfXnVJ2iS3cK5VkqCCYgeG4qvftJb/EKFu9o7f4hUopxdmqUlJUwjDYV/dDZBH4QwnppB+dLF8OLAi4quoBIK7ho00OoHrVc3aND96o37RIB73zp97fJL00uGDNwx+if8aVc/wAxL1rlJuRTacHCmdcwahbmBdN4NKlS9iCb3D8LhC/dNBY7DGyT05V2lSxZdkC4oCN9akTGgMBr50qVVtitImXiID5dfOnDi3fy6x1pUqZSYtIS8WlysadajHFWJbTbalSplJgcUE8K4o63EbLsddRWg4Zxttc67k7HaeUUqVBZOeDVoxykR70H0muLb1pUqgXHeyPlUippl8Z+VKlXDHLaQZiuskD4afDWlSrgDhED0+JqMHb1+MxSpUQEGLuGDH3THzAO9D428wCwBqBA21JP8VylTIkwXG8YZbeqDMWKspiBA1II32FVti5mwy9UuFf9rjMPmDSpVSHKI6v6WUGMMMfP+aSPSpVbuQXCLDHInss2UTO8eIqktW87KoGrGN43pUqSijk00WuD7OkPmZoysRlOu2+oofj+DHtBrrFKlU2kaEwV+E+93pCkSfOmHhImJ1iaVKi4qkCM38lfiMOFMVG2FKXVDwUJmQdcvM+dKlU2slLwXX9Bg/xP6NSpUq0VHwjJ9Xuf+z//2Q==">
  
  <p></p>
  
    <h5 class="card-title"><b>LAB FUNCTIONS</b></h5>
    <hr />
    <p class="card-text"><i>Add new reports here</i></p>
    <p></p>
    <p></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><a href="addreport">
<button type="button" class="btn btn-info">Add report</button></a></li>
    <li class="list-group-item"><a href="allreports">
<button type="button" class="btn btn-info">All reports</button></a></li>
   <li class="list-group-item"><a href="#">
<button type="button" class="btn btn-info">------------</button></a></li>
  </ul>
</div>
<div class="card" style="width: 18rem; margin:10px;">
  <div class="card-body">
  <img class="card-img-top" src="https://ak.picdn.net/offset/photos/5ea35e1dd164c0404ea4e2e2/medium/offset_933295.jpg">
  
  <p></p>
    <h5 class="card-title"><b>RECEPTIONIST FUNCTIONS</b></h5>
    <hr />
    <p class="card-text"><i>Add new patients here</i></p>
    <p></p>
    <p></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><a href="addpatient">
<button type="button" class="btn btn-info">Add patient</button></a></li>
    <li class="list-group-item"><a href="patientlist">
<button type="button" class="btn btn-info">All patients</button></a></li>

    <li class="list-group-item"><a href="#">
<button type="button" class="btn btn-info">------------</button></a></li>
  </ul>
</div>


</div>