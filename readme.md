openssl ecparam -genkey -name secp384r1 -out private.pem #����˽Կ
openssl ec -in private.pem -pubout -out public.pem #���ɹ�Կ
openssl req -new -key private.pem -out ecc.csr #����֤�������ļ�
openssl x509 -req -in ecc.csr -out ecc.cer -signkey private.pem -CAcreateserial -days 3650 #������ǩ��֤��
openssl pkcs12 -export -clcerts -in ecc.cer -inkey private.pem -out ecc.p12 #����p12��ʽ��֤��