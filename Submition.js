function sendData(data) {
    var XHR = new XMLHttpRequest();
    var urlEncodedData = "";
    var urlEncodedDataPairs = [];
    var name;

    // Transformez l'objet data en un tableau de paires clé/valeur codées URL.
    for (name in data) {
        urlEncodedDataPairs.push(encodeURIComponent(name) + '=' + encodeURIComponent(data[name]));
    }

    // Combinez les paires en une seule chaîne de caractères et remplacez tous
    // les espaces codés en % par le caractère'+' ; cela correspond au comportement
    // des soumissions de formulaires de navigateur.
    urlEncodedData = urlEncodedDataPairs.join('&').replace(/%20/g, '+');

    // Définissez ce qui se passe en cas de succès de soumission de données
    XHR.addEventListener('load', function (event) {
        alert('Ouais ! Données envoyées et réponse chargée.');
    });

    // Définissez ce qui arrive en cas d'erreur
    XHR.addEventListener('error', function (event) {
        alert('Oups! Quelque chose s\'est mal passé.');
    });

    // Configurez la requête
    XHR.open('POST', 'https://example.com/cors.php');

    // Ajoutez l'en-tête HTTP requise pour requêtes POST de données de formulaire 
    XHR.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    // Finalement, envoyez les données.
    XHR.send(urlEncodedData);
}

function createCORSRequest(method, url) {
    var xhr = new XMLHttpRequest();
    if ("withCredentials" in xhr) {

        // Check if the XMLHttpRequest object has a "withCredentials" property.
        // "withCredentials" only exists on XMLHTTPRequest2 objects.
        xhr.open(method, url, true);

    } else if (typeof XDomainRequest != "undefined") {

        // Otherwise, check if XDomainRequest.
        // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
        xhr = new XDomainRequest();
        xhr.open(method, url);

    } else {

        // Otherwise, CORS is not supported by the browser.
        xhr = null;

    }
    return xhr;
}

var xhr = createCORSRequest('GET', url);
if (!xhr) {
    throw new Error('CORS not supported');
}


JSON.stringify({"resumo_criptografico": "6fa8f018cf1ad550715378cc33a67c23edcb88e5",
"numero_casas": 8,
"cifrado": "i kwuxcbmz xzwoziu lwma epib gwc bmtt qb bw lw, vwb epib gwc eivb qb bw lw. cvsvwev",
"decifrado": "a computer program does what you tell it to do, not what you want it to do. unknown",
"token": "83ca049a9b840e7c1a64b0dc1d68c8f721e8bbca"}));