<?php
        $API_key    = 'AIzaSyDSTD4gCRs9pbqdbFlqozw-KACx9A9YDh0';
        $channelID  = 'UCUo7uJNxoFxHA0DPL8IvFvg';
        $maxResults = 10;

        $videoList = json_decode(file_get_contents('https://www.googleapis.com/youtube/v3/search?order=date&part=snippet&channelId='.$channelID.'&maxResults='.$maxResults.'&key='.$API_key.''));
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <style>
        .container{
            padding: 15px;
        }
        .youtube-video h2{
            font-size: 16px;        
        }
    </style>
</head>
<body>
    <?php
        foreach($videoList->items as $item){
            if(isset($item->id->videoId)){
                echo '<div class="youtube-video">
                        <iframe width="280" height="150" src="https://www.youtube.com/embed/'.$item->id->videoId.'" frameborder="0" allowfullscreen></iframe>
                        <h2>'. $item->snippet->title .'</h2>
                    </div>';
            }
        }
    ?>
</body>
</html>