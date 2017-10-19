const fs = require('fs');
var args=process.argv.slice(2);
var maxName='NONE';
var maxLength=0;

function generator(name,pos){
    return function(err,data){
        if(!err){
            console.log('Processing %s...',name);
            if(data.length>maxLength){
                maxLength=data.length;
                maxName=name;
            }
        }
        if(pos==args.length-1){
            console.log('The longest file is %s and its length is %d bytes',maxName,maxLength);            
        }
    }
}

for(var i=0;i<args.length;i++){
    fs.readFile(args[i],'utf8',generator(args[i],i));
}