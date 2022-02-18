path_inputs = {
    'clowdflows': '/media/disk1/home/boylen/LenCode/clowdflows_v3',
    'python_packages': '/home/boylen/anaconda3/envs/ClowdFlowPy27/lib/python2.7/site-packages',
    'django': '',
    'data_segy': '/media/disk1/home/boylen/LenData/Segy',
    'len_bridge': ''
}

# Gen1
CLOWDFLOWS = path_inputs['clowdflows']
PYTHON_PKG = path_inputs['python_packages']
DATA_SEGY = path_inputs['data_segy']
LENBRIDGE = path_inputs['len_bridge']

# Gen2
IP_ADAPTER_REPLACE = PYTHON_PKG + '/django/core/management/commands/runserver.py'
IP_ADAPTER_ORIGIN = CLOWDFLOWS + '/Home/boyLen/Data/LenSystem/runserver_replace_origin.py'
CF_WEBSITE_STATIC = CLOWDFLOWS + '/website/static'
CF_WORKFLOWS_VISUAL = CLOWDFLOWS + '/workflows/templates/visualizations'
LEN_VISUAL_WEB = CLOWDFLOWS + '/workflows/templates/visualizations/boyLen_Web'