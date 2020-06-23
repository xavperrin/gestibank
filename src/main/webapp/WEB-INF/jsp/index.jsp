<!doctype html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <title>Gestibank</title>
        <meta name="description" content="Gestion de compte bancaire en ligne">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- Chargement Police Roboto -->
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <!-- Chargement Police FontAwesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <!-- Chargement Feuille de style principale -->
             <link href="/resources/css/main.css" />
    </head>

    <body>bbbb
        
        <header>
            <div class="container">
                <div class="elements">
                    <a href="index.html">Gesti<small> Bank</small></a>
                    
                    <nav>
                        <ul>
                            <li><a href="/disconnect">Connexion</a></li>
                            <li><a href="/connect">D&eacuteconnexion</a></li>
                        </ul>
                    </nav>
                    <a href="#" class="header__icon" id="header__icon"></a>
                </div>
            </div>
        </header>
        
        <main>
            
            <div class="block" id="presentation">
                <div class="container">
                    <h1>Gestibank</h1>
                    <p>Connectez vous à votre compte en ligne depuis chez vous ou sur votre mobile.</p>
                </div>
            </div>
            
            <div class="block" id="characters">
                
                <div class="container">
                    
                    <h2>Creez votre compte</h2>
                        <form method="post" action="subscribe.jsp">
                            <div class="form-group">
                                <label for="labelEmail">Votre email : </label>
                                <input type="email" name="email" id="labelEmail">
                            </div>
                            <input type="submit" value="Envoyer"/>
                        </form>

                    
                </div>
                
            </div>
            
            
            
        </main>
        
        
        <footer>
            <div class="container">

                <div class="elements">
                    <p>Copyright 2018 ...</p>

                    <div class="social">
                        <ul>
                            <li>
                                <a href="https://www.facebook.com/GestiBank/" target="_blank"><i class="fab fa-facebook fa-2x"></i></a>
                            </li>
                            <li>
                                <a href="https://www.youtube.com/Gestibank/" target="_blank"><i class="fab fa-youtube fa-2x"></i></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/gestibank/" target="_blank"><i class="fab fa-twitter fa-2x"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
        </footer>
    </body>

</html>
