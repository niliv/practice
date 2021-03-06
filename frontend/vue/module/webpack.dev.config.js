const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
    entry:{
        'main':'./src/main.js'
    },
    output:{
        path: path.resolve('./dist'),
        filename:'build.js'
    },
    watch:true,
    module:{
        loaders:[
            {
                test:/\.css$/,
                loader:'style-loader!css-loader'
            },
            {
                test:/\.(jpg|png)/,
                loader:'url-loader?limit=30000'
            },
            {
                test:/\.less$/,
                loader:'style-loader!css-loader!less-loader'
            }
        ]
    },
    plugins:[
        new HtmlWebpackPlugin({
            template:'./src/index.html'
        })
    ]
}