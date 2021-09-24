from jose import jwk, jwt
'''
https://stackoverflow.com/questions/62822313/how-to-validate-es384-jwt-signature-with-x-and-y-coordinate-in-python

pip install python-jose

'''

'''
X:0L5Iij+EpI+5SPN0CBvLOCgK5yah5Imo4URJFQSPag1FK8Bn9ISe6CZg1GrT1WQf
Y:RQzEiKs29cWpGPP546yHEqunBDuLgj1VmrwzzCkJgMH/QXKFcQHucen+jPhltzqi
D:xCgpenX+mMMNUa4bM5/mI92y+YM0PbZaSktbiDRz/82bFaW7m8Vik/rG2ukMH/NQ
eyJhbGciOiJFUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJraXNzbWV0dEAxNjMuY29tIiwiZXhwIjoxMzAwODE5MzgwfQ.ZPD6cIG_03YtnAY-YTxJ_fzLR2727VDRwHtuJlnnslDKyIATDJdxwJwL7Ge1a7UHbsA--V_TT6p2a-Euphk1wOIF0GkP_9N2pVM8hmYoVQxVdpvcdEedyQSw3hvqXYwI

X:OMr/070PGZCw7FuF1WcnXDBM1tY/5KIPpSSkUCTwRQwK9i81P5KtJeePB9skRF5b
Y:SO37ElSIT9EQiCbEcit/x2fF8qCXvBiKA6VnyrZqy08+ygkutqu5Y3ymX1Zd7ubR
D:8czgTlG5JX9eAiUAQhfa6BC9yFZcBedZQUPQqWq4RrNcketzSuHzIpRrtwDHfhH1
eyJhbGciOiJFUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJraXNzbWV0dEAxNjMuY29tIiwiZXhwIjoxMjE4MTU0MDg4fQ.R39NLISa3NtPB2IMyTL8z8RqGJPqIbohpHBXpfjMjpTo0hdHxOw5B8PLI8gunX0-DKFhs4bhF331m0R0c6UzeFnPTN3Zl-28aoOJB-v0gIho3MoghxCSgxAFo5q8VgKI
'''
'''
P12:
x: AKDSRInmG0PiieQEr/FuuwCegONcRr60QG3YPTGbms9J67lPbgcPuoV96tKQFf2E6A==
y: ANYFi7LHeJl2lql9xKRACirozXi9tOPNs2hvNNebIK36j9kAd0px0iaNc07O5hKMHQ==
eyJhbGciOiJFUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJraXNzbWV0dEAxNjMuY29tIiwiZXhwIjoxMjE4MTU0MDg4fQ.7LJei4MwJ7A1AZkKTe8nWA3Zh0DMO4sNbn03i7Cb-huhzcNaRkFhbuQKjah6E4E53uQGi7iJLdw1YchCtLtQdu1xcvGX6NY9tfXlqSqvrlUFampkMnZW9TRQemkQXmsP
'''
es384_key = {
    "kty": "EC",
    "crv": "P-384",
    "kid": "x1",
    "use": "sig",
    "alg": "ES384",
    "x": "AKDSRInmG0PiieQEr/FuuwCegONcRr60QG3YPTGbms9J67lPbgcPuoV96tKQFf2E6A==",
    "y": "ANYFi7LHeJl2lql9xKRACirozXi9tOPNs2hvNNebIK36j9kAd0px0iaNc07O5hKMHQ=="
}

#allowed_aud = "http://127.0.0.1:8000/cds-services"
token = "eyJhbGciOiJFUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJraXNzbWV0dEAxNjMuY29tIiwiZXhwIjoxMjE4MTU0MDg4fQ.7LJei4MwJ7A1AZkKTe8nWA3Zh0DMO4sNbn03i7Cb-huhzcNaRkFhbuQKjah6E4E53uQGi7iJLdw1YchCtLtQdu1xcvGX6NY9tfXlqSqvrlUFampkMnZW9TRQemkQXmsP"
payload = jwt.decode(
                token,
                es384_key,
                #audience = allowed_aud,
                options = {'verify_exp':False})

print (payload)
