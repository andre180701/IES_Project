import itertools

class Client:
    newid = itertools.count()
    def __init__(self, registration, deviceId) -> None:
        self._id = next(Client.newid)
        self._registration = registration
        self._deviceId = deviceId

    def get_id(self):
        return self._id

    def get_registration(self):
        return self._registration

    def get_deviceId(self):
        return self._deviceId

    def set_registration(self, registration):
        self._registration = registration

    def set_deviceId(self, deviceId):
        self._deviceId = deviceId

    '''
    def __str__(self) -> str:
        return 

    def __repr__(self) -> str:
        return self.__str__()
    '''
