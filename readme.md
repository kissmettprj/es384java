openssl ecparam -genkey -name secp384r1 -out private.pem #生成私钥

openssl ec -in private.pem -pubout -out public.pem #生成公钥

openssl req -new -key private.pem -out ecc.csr #生成证书请求文件

openssl x509 -req -in ecc.csr -out ecc.cer -signkey private.pem -CAcreateserial -days 3650 #生成自签根证书

openssl pkcs12 -export -clcerts -in ecc.cer -inkey private.pem -out ecc.p12 #导出p12格式根证书
