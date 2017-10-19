const fs = require('fs');
var args = process.argv.slice(2);
console.log(args)
var maxName = 'NONE';
var maxLength = 0;

for (var i=0;i<args.length;i++){
    fs.readFile(args[i],'utf8',function(err,data){
        if(!err){
            console.log('Processing %s ...', args[i] );
            if(data.length>maxLength){
                maxLength=data.length;
                maxName=args[i];
            }
        }
    })
}
console.log('The longest file is %s and its length is %d bytes',maxName,maxLength);